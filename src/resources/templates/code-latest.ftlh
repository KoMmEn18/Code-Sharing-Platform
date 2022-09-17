<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Latest</title>
    <link rel="stylesheet" href="/css/code.css">
</head>
<body>
    <#list codes as code>
        <div class="code-box">
            <span id="load_date">${code.getDateFormatted()}</span>
            <pre id="code_snippet">${code.getCode()}</pre>
        </div>
    </#list>
</body>
</html>