<html lang="en">
<head>
    <meta charset="utf-8">
</head>
<body>
<div class="mainbar">
    <div id="console" class="console" style="opacity: 1;">
        <input type="text" name="query" required="required" id="input-query">
        <button onclick="searchFunction()" id="searchButton"> search</button>
    </div>
    <div id="result-div">

    </div>
    <button onclick="appendNextResultFunction()" id="appendNextResultButton"> show next results </button>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="/js/javascript.js"></script>
</body>
</html>