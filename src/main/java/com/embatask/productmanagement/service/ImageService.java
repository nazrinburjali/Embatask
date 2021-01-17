package com.embatask.productmanagement.service;

import com.embatask.productmanagement.domain.Image;
import com.embatask.productmanagement.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public Image addImage(Image image) {
        return imageRepository.save(image);
    }

    public List<Image> getAll() {
        List<Image> imageList = new ArrayList<>();
        Iterable<Image> imageIterable = imageRepository.findAll();
        imageIterable.forEach(imageList::add);
        return imageList;
    }

    public Image getImageById(int id) {
        Optional<Image> optionalImage = imageRepository.findById(id);
        Image image = null;
        if (optionalImage.isPresent()) {
            image = optionalImage.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, id + " id-li image yoxdur");
        }
        return image;
    }

    public Image updateImage(Image image) {
        Optional<Image> optionalImage = imageRepository.findById(image.getImageID());
        if (optionalImage.isPresent()) {
            return imageRepository.save(image);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, image.getImageID() + " id-li image yoxdur");
        }
    }

    public void deleteImage(int id) {
        Optional<Image> optionalImage = imageRepository.findById(id);
        if (optionalImage.isPresent()) {
            imageRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, id + " id-li image yoxdur");
        }
    }


}
