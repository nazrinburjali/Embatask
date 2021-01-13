package com.embatask.productmanagement.controller;

import com.embatask.productmanagement.domain.Category;
import com.embatask.productmanagement.domain.Product;
import com.embatask.productmanagement.service.CategoryService;
import com.embatask.productmanagement.service.ProductService;
import com.embatask.productmanagement.util.FileUtility;
import com.embatask.productmanagement.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Value("${upload.folder}")
    private String uploadFolder;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductValidator productValidator;

    @InitBinder
    public void  initProductBinder(WebDataBinder dataBinder) {
        if(dataBinder.getTarget() != null && (dataBinder.getTarget()).getClass() == Product.class){
            dataBinder.setValidator(productValidator);
        }
    }

    @GetMapping("/")
    public String showIndex(){
        return "admin/index";
    }

    @GetMapping("/products")
    public ModelAndView getProductList() {
        ModelAndView mav = new ModelAndView("/admin/products");
        List<Product> productList = productService.getAll();
        mav.addObject("productList", productList);
        return mav;
    }


    @GetMapping("/new-product")
    public ModelAndView newProductPage() {
        ModelAndView mav = new ModelAndView("/admin/new-product");
        List<Category> categories = categoryService.getSubCategories();
        mav.addObject("categories", categories);
        mav.addObject("product", new Product());
        return mav;
    }

    @PostMapping("/new-product-submit")
    public ModelAndView newProductSubmit(@ModelAttribute @Validated Product product,BindingResult result,
                                         @RequestParam(name = "image1") MultipartFile image1,
                                         @RequestParam(name = "image2", required = false) MultipartFile image2) {
        ModelAndView mav = new ModelAndView();
        if (result.hasErrors()){
            System.out.println("Formda xətalar var");
            result.getAllErrors();
            mav.setViewName("admin/new-product");
            List<Category> categories = categoryService.getSubCategories();
            mav.addObject("categories", categories);
        }
        else{
            productService.addProduct(product);
            try{
                System.out.println("Original name" + image1.getOriginalFilename());
                System.out.println("File name" + image1.getName());
                System.out.println("Content type" + image1.getContentType());
                System.out.println("Size" + image1.getSize());

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                String fileName = String.format("%s%smedia-%s-%d%s",
                        uploadFolder,
                        File.separator,
                        LocalDateTime.now().format(formatter),
                        LocalDateTime.now().getNano(),
                        FileUtility.getFileExtension(image1.getOriginalFilename()));
                System.out.println("file name" + fileName);
                System.out.println("Məhsul əlavə edildi");
                Path filePath = Paths.get(fileName);
                if (!Files.exists(filePath.getParent())){
                    Files.createDirectory(filePath.getParent());
                    System.out.println("Created upload folder");
                }
                Files.copy(image1.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            mav.setViewName("redirect:/admin/products");}

        return mav;
    }

    @GetMapping("product/edit/{id}")
    public ModelAndView showEditPage(@PathVariable int id){
        ModelAndView mav = new ModelAndView("admin/edit-product");
        Product product = productService.getProductById(id);
        List<Category>categories = categoryService.getSubCategories();
        mav.addObject("categories", categories);
        mav.addObject("product", product);
        return mav;
    }

    @PostMapping("product/edit/{id}")
    public ModelAndView updateProduct(@ModelAttribute Product product){
        return new ModelAndView("redirect:/admin/products");
    }

    @GetMapping("/product/delete/{id}")
    public ModelAndView deleteProductById(@PathVariable int id){
        productService.deleteProduct(id);
        return new ModelAndView("redirect:/admin/products");
    }


}
