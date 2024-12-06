<!doctype html>
<html lang="en">

<head th:fragment="head">
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>Demo</title>
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width" />
    <base href="/" />
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/dist/css/bootstrap.min.css" />
    <script type="importmap">
        {
            "imports": {
                "bootstrap": "/npm/bootstrap",
                "@popperjs/core": "/npm/@popperjs/core",
                "htmx": "/webjars/htmx.org/1.6.0/dist/htmx.js"
            }
        }
    </script>
    <script type="module">
        import 'bootstrap';
        import '@popperjs/core';
        import 'htmx';
    </script>
    <script src="/webjars/htmx.org/1.6.0/dist/htmx.js"></script>
</head>
<body>
	<header th:fragment="header" class="m-2">
        <h1 class="text-center">Linear Algebra Calulator Test</h1>
    </header>
	<main>
        <div class="container-flex">
            <div class="row align-items-center text-center m-2 min-vh-100">
                <div class="col-3"></div>
                <div class="col-6 m-3 text-center">
                    <h1 class="text-center">Error</h1>
                    <h3>There was an error processing your request. Please click the big red button to go back to the homepage.</h3>
                    <a class="btn btn-lg btn-danger"
                        href="/"
                    >Go Home</a>
                </div>
                <div class="col-3"></div>
            </div>
        </div>
	</main>
</body>
</html>