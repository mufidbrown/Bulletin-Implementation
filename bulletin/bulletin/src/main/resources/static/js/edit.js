let postId;
$(document).ready(function(){
    let params = new URLSearchParams(window.location.search);
    postId = params.get("id");
    console.log("POST ID:", postId);
    if(!postId){
        alert("Post ID not found");
        return;
    }
    loadPost(postId);
});

function loadPost(id){
    $.ajax({
        url:"http://localhost:8089/api/posts/"+id,
        method:"GET",
        success:function(res){
            let p = res.data;
            $("#authorName").val(p.authorName);
            $("#title").val(p.title);
            $("#content").val(p.content);
        },

        error:function(){
            alert("Failed to load post data");
        }
    });
}

function updatePost(){
    let data = {
        authorName: $("#authorName").val(),
        password: $("#password").val(),
        title: $("#title").val(),
        content: $("#content").val()
    };

    $.ajax({
        url:"http://localhost:8089/api/posts/"+postId,
        method:"PUT",
        contentType:"application/json",
        data:JSON.stringify(data),

        success:function(){
            alert("Update success");
            window.location.href="detail.html?id="+postId;
        },

        error:function(err){
            console.log(err);
            alert("Update failed");
        }
    });
}
