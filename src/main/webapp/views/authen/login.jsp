<%-- Document : login Created on : Nov 15, 2023, 4:35:50 PM Author : caomi --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Đăng nhập vào TinDict</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootswatch@5.3.2/dist/lux/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@200;300;400;500;600;700&amp;display=swap">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Averia+Serif+Libre&amp;display=swap">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
</head>

<body>
    <section class="position-relative py-4 py-xl-5" style="height: auto;">
        <div class="container" style="width: 100vw;height: 100vh;">
            <div class="row mb-5">
                <div class="col-md-8 col-xl-6 text-center mx-auto">
                    <h2 style="font-weight: bold;font-size: 26px;">Đăng nhập</h2>
                    <p class="w-lg-50">Vui lòng đăng nhập vào trang quản lý TinDict.</p>
                </div>
            </div>
            <div class="row d-flex justify-content-center" style="width: 100%;">
                    <div class="col-12 col-md-10 col-lg-8 col-xl-6 col-xxl-6 offset-0 offset-xl-0">
                        <div class="card mb-5" style="width: 100%;height: 100%;">
                            <div class="card-body d-flex flex-column align-items-center" style="padding: 0px;padding-bottom: 47px;box-shadow: 0px 0px 10px;width: 100%;height: 100%;">
                                <div class="bs-icon-xl bs-icon-circle bs-icon-primary bs-icon my-4"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-person">
                                    <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z"></path>
                                    </svg></div>
                                <form class="text-center" method="post" style="width: 60%;height: 100%;">
                                    <div class="mb-3" style="width: 100%;"><input name="username" class="form-control" type="text" placeholder="Username" required="" style="border-width: 1px;border-color: var(--bs-emphasis-color);"></div>
                                    <div class="mb-3"><input name="password" class="form-control" type="password" placeholder="Password" required="" style="width: 100%;border-width: 1px;border-color: var(--bs-emphasis-color);"></div>
                                    <div class="mb-3" style="width: 100%;">
                                        <div class="form-check"><input name="remember" class="form-check-input" type="checkbox" id="formCheck-1" style="border: 1.90566px solid rgb(15,14,14) ;"><label class="form-check-label" for="formCheck-1">Ghi nhớ đăng nhập</label></div>
                                    </div>
                                    <div class="mb-3" style="width: 100%;"><button class="btn btn-primary d-block w-100" type="submit">Login</button></div>
                                    <p class="text-muted" style="text-align: left;color: #55595c;width: 100%;">Chưa có tài khoản?&nbsp;<a style="color: rgba(26,26,26,0.58);" href="register.html">Đăng ký tài khoản mới</a></p><a style="color: rgba(26,26,26,0.58);">Quên mật khẩu?</a>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    </section>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>