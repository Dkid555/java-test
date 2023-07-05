function start() {
    var element = document.getElementById("progressBar");
    var width = 1;
    var identity = setInterval(scene, 10);

    function scene() {
        if (width >= 100) {
            clearInterval(identity);
            width = 0;
        } else {
            width++;
            element.style.width = width + '%';
        }
    }
}