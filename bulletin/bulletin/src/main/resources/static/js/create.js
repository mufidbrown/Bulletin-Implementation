function createPost(){
    let data = {

        authorName: $("#authorName").val(),
        password: $("#password").val(),
        title: $("#title").val(),
        content: $("#content").val()
    };

    $.ajax({
        url: "http://localhost:8089/api/posts/create",
        method: "POST",
        contentType: "application/json",
        data: JSON.stringify(data),

        success: function(res){
            alert("Post created");
            window.location.href="list.html";
        },

        error:function(err){
            console.log(err);
            alert("Create failed");
        }
    });
}
