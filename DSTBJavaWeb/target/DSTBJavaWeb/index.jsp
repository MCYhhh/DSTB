<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <style>
        body{
            width: 100%;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            /*background: #34495e;*/
            background-image: linear-gradient(120deg,#FFC1C1 0%,#87CEFA 100%);
            margin: 0;
            padding: 0;
            font-family: "montserrat",sans-serif;
        }
        .loading{
            width: 200px;
            height: 200px;
            box-sizing: border-box;
            border-radius: 50%;;
            border-top: 10px solid #e7473c;
            animation: loading1 2s linear infinite;
            position: relative;
        }
        .loading:before,.loading:after{
            content: "";
            position: absolute;
            left: 0;
            top: -10px;
            width: 200px;
            height: 200px;
            border-radius: 50%;
            box-sizing: border-box;
        }
        .loading:before{
            border-top: 10px solid #e67e22;
            transform: rotate(120deg);
        }
        .loading:after{
            border-top: 10px solid #3498db;
            transform: rotate(240deg);
        }
        .loading span{
            position: absolute;
            width: 200px;
            height: 200px;
            text-align: center;
            line-height: 200px;
            color: #fff;
            animation: loading2 2s linear infinite;
        }

        @keyframes loading1{
            to{
                transform: rotate(360deg);
            }
        }
        @keyframes loading2{
            to{
                transform: rotate(-360deg);
            }
        }
    </style>
</head>
<body>

<div class="loading">
    <span>loading...</span>
</div>
<script>
    function jumpurl(){
        location='/DSTBJavaWeb/Login/login.html';
    }
    setTimeout('jumpurl()',3000);
</script>


</body>



</html>

