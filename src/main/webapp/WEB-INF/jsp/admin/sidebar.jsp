<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 12.01.2021
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="pcoded-navbar">
    <div class="sidebar_toggle"><a href="#"><i class="icon-close icons"></i></a></div>
    <div class="pcoded-inner-navbar main-menu">

        <ul class="pcoded-item pcoded-left-item">
            <li class="active">
                <a href="${pageContext.request.contextPath}/admin/products">
                    <span class="pcoded-micon"><i class="ti-home"></i><b>D</b></span>
                    <span class="pcoded-mtext" data-i18n="nav.dash.main">Products</span>
                    <span class="pcoded-mcaret"></span>
                </a>
            </li>
        </ul>
        <ul class="pcoded-item pcoded-left-item">
            <li class="active">
                <a href="${pageContext.request.contextPath}/admin/new-product">
                    <span class="pcoded-micon"><i class="ti-home"></i><b>D</b></span>
                    <span class="pcoded-mtext" data-i18n="nav.dash.main">New product</span>
                    <span class="pcoded-mcaret"></span>
                </a>
            </li>
        </ul>



    </div>
</nav>
