<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create</title>
    <link rel="stylesheet" href="/css/new-code.css">
</head>
<body>
<form>
    <textarea id="code_snippet" required="required"></textarea>
    <div>
        <label for="time_restriction">Time</label>
        <input id="time_restriction" type="text" required="required"/>
    </div>
    <div>
        <label for="views_restriction">Views</label>
        <input id="views_restriction" type="text" required="required"/>
    </div>
    <button id="send_snippet" type="submit" onclick="send()">Submit</button>
</form>
</body>
<script src="/js/script.js"></script>
</html>