let postId;

$(document).ready(function(){
    let params = new URLSearchParams(window.location.search);
    postId = params.get("id");
    console.log("POST ID:", postId);
    if(!postId){
        alert("Post ID not found");
        window.location.href="list.html";
        return;
    }
});

function deletePost(){
    let password = $("#password").val();
    if(!password){
        alert("Please enter password");
        return;
    }

    $.ajax({
        url:"http://localhost:8089/api/posts/"+postId,
        method:"DELETE",
        contentType:"application/json",
        data:JSON.stringify({
            password:password
        }),

        success:function(){
            alert("Post deleted successfully");
            window.location.href="list.html";
        },

        error:function(err){
            console.log(err);
            alert("Delete failed. Password may be incorrect.");
        }
    });
}
