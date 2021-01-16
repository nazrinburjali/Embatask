<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 13.01.2021
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="common/meta.jsp"/>
    <title>Register</title>
    <jsp:include page="common/css.jsp"/>
    <style>
        .error{
            color:red;
        }
    </style>
</head>
<body>
<%--<jsp:include page="common/header.jsp"/>--%>

<!-- slider Area Start-->
<div class="slider-area ">
    <!-- Mobile Menu -->
    <div class="single-slider slider-height2 d-flex align-items-center" data-background="assets/img/hero/category.jpg">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="hero-cap text-center">
                        <h2>Registration</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- slider Area End-->


<!--================Login Box Area =================-->
<section class="login_box_area section-margin">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="login_box_img">
                    <div class="hover">
                        <h4>Already have an account?</h4>
                        <a class="button button-account" href="/login">Login Now</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="login_form_inner register_form_inner">
                    <h3>Create an account</h3>
                    <form:form   class="row login_form" modelAttribute="user" method="post" action="/register-submit">
                        <form:hidden path="userID"/>
                        <div class="col-md-12 form-group">
                            <form:input path="userName" class="form-control" placeholder="Name" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Name'"/><br>
                            <form:errors path="userName" cssClass="error"/>
                        </div>
                        <div class="col-md-12 form-group">
                            <form:input path="userSurname" class="form-control" placeholder="Surname" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Surname'"/><br>
                            <form:errors path="userSurname" cssClass="error"/>
                        </div>
                        <div class="col-md-12 form-group">
                            <form:input path="userEmail" type="email" class="form-control" placeholder="Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email'"/><br>
                            <form:errors path="userEmail" cssClass="error"/>
                        </div>
                        <div class="col-md-12 form-group">
                            <form:input path="userPhone" class="form-control" placeholder="Phone" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Phone'"/><br>
                            <form:errors path="userPhone" cssClass="error"/>
                        </div>
                        <div class="col-md-12 form-group">
                            <form:password path="userPassword" class="form-control" placeholder="Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'"/><br>
                            <form:errors path="userPassword" cssClass="error"/>
                        </div>
                        <br>
                               <div class="col-md-12 form-group">
                            <button type="submit" value="submit" class="button button-register w-100">Register</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================End Login Box Area =================-->


<%--<jsp:include page="common/footer.jsp"/>--%>


<jsp:include page="common/js.jsp"/>
</body>
</html>
