$(document).ready(function(){

    let params = new URLSearchParams(window.location.search);
    let postId = params.get("id");
    loadDetail(postId);
    $("#editBtn").attr("href","edit.html?id="+postId);
    $("#deleteBtn").attr("href","delete.html?id="+postId);
});

function loadDetail(postId){
    $.ajax({
        url:"http://localhost:8089/api/posts/"+postId,
        method:"GET",
        success:function(res){
            let p=res.data;
            $("#postDetail").html(`
<h4>Post #${p.id}</h4>
<h3>${p.title}</h3>
<p>Author: ${p.authorName}</p>
<p>Views: ${p.viewCount}</p>
<p>Created: ${p.createdAt}</p>
<hr>
<p>${p.content}</p>
`);

        }
    });
}
