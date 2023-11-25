<%-- 
    Document   : create-word
    Created on : Nov 25, 2023, 6:27:31 PM
    Author     : caomi
--%>

<%@page import="com.quancm.tincode.models.Word"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-bs-theme="light" lang="en" data-bss-forced-theme="light">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Sửa từ</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@5.3.2/dist/cerulean/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Averia+Serif+Libre&amp;display=swap">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="assets/css/styles.min.css">
    <%
        Word word = (Word)request.getAttribute("word");
    %>
</head>

<body style="background: linear-gradient(90deg, #FCF5EC, #BDDFF6);">
    <header style="background-color: inherit;">
        <nav class="navbar navbar-expand-md bg-body" style="background: linear-gradient(90deg, #FCF5EC, #BDDFF6);">
            <div class="container-fluid"><a class="navbar-brand fs-1" href="./" style="width: 10%;font-weight: bold;font-size: 23px;text-align: center;">TeenDict</a>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul class="navbar-nav justify-content-between ms-auto" style="width: 50%;margin-left: -7.4219px;height: 100%;">
                        <li class="nav-item" style="width: 30%;height: 100%;margin-right: 0px;"></li>
                        <li class="nav-item" style="width: 30%;height: 100%;margin-right: 0px;"></li>
                        <li class="nav-item" style="width: 30%;height: 100%;"><a class="btn btn-dark text-center" role="button" style="padding: 0;padding-top: 10px;padding-bottom: 10px;border-width: 1px;height: 100%;width: 100%;margin: 0px;font-size: 14px;line-height: 20px;letter-spacing: 1px;" href="./logout">Đăng Xuất</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <div style="width:100%;height:100%;">
        <div class="container-fluid" style="width: 100%;max-width: 60%;padding: 0;padding-top: 15px;padding-bottom: 15px;height: 100%;">
            <h2>${status}</h2>
            <form method="post" style="width:100%;height:100%;">
                <div class="card shadow mb-3" style="width: 100%;height: 100%;margin: 0;">
                    <div class="card-header py-3" style="width: 100%;height: 100%;padding: 0;">
                        <p class="fs-4 fw-bolder text-start text-primary m-0 fw-bold">Sửa từ</p>
                    </div>
                    <div class="card-body" style="width: 100%;height: 100%;min-height: 0px;padding: 0;margin: 0;">
                        <div class="row" style="width: 100%;margin: 2px;padding: 0;">
                            <div class="col-sm-12 col-md-8 col-lg-8 col-xxl-8" style="transform: scale(1);width: 100%;">
                                <div class="mb-3">
                                    <label class="form-label form-label" for="service_name"><strong>Keyword *</strong></label>
                                    <input value="<%=word.getWord()%>" class="form-control form-control" type="text" id="service_name-2" name="word" placeholder="Nhập keyword" required="" style="border-color:rgb(0,0,0);color:rgb(0,0,0);">
                                </div>
                            </div>
                        </div>
                        <div class="row" style="width: 100%;margin: 2px;padding: 0;">
                            <div class="col-sm-12 col-md-8 col-lg-8 col-xxl-8" style="transform: scale(1);width: 100%;">
                                <div class="mb-3" style="width: 100%;margin: 2px;padding: 0;">
                                    <label class="form-label form-label" for="client_description"><strong>Định nghĩa *</strong></label>
                                    <textarea class="form-control form-control" id="service_description-1" name="definition" placeholder="Nhập định nghĩa" required="" rows="4" style="color: rgb(0,0,0);height: 100px;width: 100%;border-color: rgb(0,0,0);"><%=word.getDefinition()%></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="row" style="width: 100%;margin: 2px;padding: 0;">
                            <div class="col-sm-12 col-md-8 col-lg-8 col-xxl-8" style="transform: scale(1);width: 100%;">
                                <div class="mb-3">
                                    <label class="form-label form-label" for="service_name"><strong>Nguồn gốc *</strong></label>
                                    <input value="<%=word.getOriginal()%>" class="form-control form-control" type="text" id="service_name-1" name="original" placeholder="Nhập nguồn gốc" required="" style="border-color:rgb(0,0,0);color:rgb(0,0,0);">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row" style="width: 100%;margin: 2px;padding: 0;">
                        <div class="col-sm-12 col-md-8 col-lg-8 col-xxl-8" style="transform: scale(1);width: 100%;">
                            <div class="mb-3" style="width: 100%;margin: 2px;padding: 0;">
                                <label class="form-label form-label" for="client_description"><strong>Ví dụ *</strong></label>
                                <textarea class="form-control form-control" id="service_description-2" name="example" placeholder="Nhập ví dụ" required="" rows="4" style="color: rgb(0,0,0);height: 100px;width: 100%;border-color: rgb(0,0,0);"><%=word.getExample()%></textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="text-end mb-3"><button class="btn btn-secondary" type="submit">Tạo từ</button><a class="btn btn-dark" role="button" href="./">Huỷ</a></div>
            </form>
        </div>
    </div>
    <footer class="text-center fixed-bottom-footer" style="background: linear-gradient(90deg, #FCF5EC, #BDDFF6);">
        <div class="container text-muted py-4 py-lg-5" style="padding: 0px 12px;">
            <ul class="list-inline">
                <li class="list-inline-item me-4"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-facebook">
                        <path d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z"></path>
                    </svg></li>
                <li class="list-inline-item me-4"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-twitter">
                        <path d="M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15z"></path>
                    </svg></li>
                <li class="list-inline-item"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-instagram">
                        <path d="M8 0C5.829 0 5.556.01 4.703.048 3.85.088 3.269.222 2.76.42a3.917 3.917 0 0 0-1.417.923A3.927 3.927 0 0 0 .42 2.76C.222 3.268.087 3.85.048 4.7.01 5.555 0 5.827 0 8.001c0 2.172.01 2.444.048 3.297.04.852.174 1.433.372 1.942.205.526.478.972.923 1.417.444.445.89.719 1.416.923.51.198 1.09.333 1.942.372C5.555 15.99 5.827 16 8 16s2.444-.01 3.298-.048c.851-.04 1.434-.174 1.943-.372a3.916 3.916 0 0 0 1.416-.923c.445-.445.718-.891.923-1.417.197-.509.332-1.09.372-1.942C15.99 10.445 16 10.173 16 8s-.01-2.445-.048-3.299c-.04-.851-.175-1.433-.372-1.941a3.926 3.926 0 0 0-.923-1.417A3.911 3.911 0 0 0 13.24.42c-.51-.198-1.092-.333-1.943-.372C10.443.01 10.172 0 7.998 0h.003zm-.717 1.442h.718c2.136 0 2.389.007 3.232.046.78.035 1.204.166 1.486.275.373.145.64.319.92.599.28.28.453.546.598.92.11.281.24.705.275 1.485.039.843.047 1.096.047 3.231s-.008 2.389-.047 3.232c-.035.78-.166 1.203-.275 1.485a2.47 2.47 0 0 1-.599.919c-.28.28-.546.453-.92.598-.28.11-.704.24-1.485.276-.843.038-1.096.047-3.232.047s-2.39-.009-3.233-.047c-.78-.036-1.203-.166-1.485-.276a2.478 2.478 0 0 1-.92-.598 2.48 2.48 0 0 1-.6-.92c-.109-.281-.24-.705-.275-1.485-.038-.843-.046-1.096-.046-3.233 0-2.136.008-2.388.046-3.231.036-.78.166-1.204.276-1.486.145-.373.319-.64.599-.92.28-.28.546-.453.92-.598.282-.11.705-.24 1.485-.276.738-.034 1.024-.044 2.515-.045v.002zm4.988 1.328a.96.96 0 1 0 0 1.92.96.96 0 0 0 0-1.92zm-4.27 1.122a4.109 4.109 0 1 0 0 8.217 4.109 4.109 0 0 0 0-8.217zm0 1.441a2.667 2.667 0 1 1 0 5.334 2.667 2.667 0 0 1 0-5.334z"></path>
                    </svg></li>
            </ul>
            <p class="mb-0">Copyright © 2023 TeenDict</p>
        </div>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>