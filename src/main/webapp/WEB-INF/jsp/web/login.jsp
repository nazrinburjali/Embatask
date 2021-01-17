<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 14.01.2021
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>

<!doctype html>
<html lang="en">

<head>
    <jsp:include page="common/meta.jsp"/>
    <title> Login </title>
    <jsp:include page="common/css.jsp"/>
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
                        <h2>Login</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- slider Area End-->

<!--================login_part Area =================-->
<section class="login_part section_padding ">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-6 col-md-6">
                <div class="login_part_text text-center">
                    <div class="login_part_text_iner">
                        <h4>Don't have an account yet?</h4>
                        <a href="/register" class="btn_3">Create an Account</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <div class="login_part_form">
                    <div class="login_part_form_iner">
                        <h3>Welcome Back ! <br>
                            Please Sign in now</h3>
                        <form class="row contact_form" action="login" method="post" novalidate="novalidate">
                            <div class="col-md-12 form-group p_star">
                                <c:if test="${param.error != null}">
                                    Username or password is invalid
                                </c:if>
                                <c:if test="${not empty param.logout}">
                                    Successfully logged out
                                </c:if>
                                <input type="email" class="form-control" id="email" name="username" value=""
                                       placeholder="Email"/>
                            </div>
                            <div class="col-md-12 form-group p_star">
                                <input type="password" class="form-control" id="password" name="password" value=""
                                       placeholder="Password"/>
                            </div>
                            <div class="col-md-12 form-group">
                                <div class="creat_account d-flex align-items-center">
                                    <input type="checkbox" id="f-option" name="remember-me">
                                    <label for="f-option">Remember me</label>
                                </div>
                                <button type="submit" value="submit" class="btn_3">
                                    log in
                                </button>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================login_part end =================-->

<jsp:include page="common/js.jsp" />

</body>

</html>