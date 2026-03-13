$(document).ready(function(){
    loadPosts();
});

function loadPosts(){
    $.ajax({
        url:"http://localhost:8089/api/posts/all",
        method:"GET",
        success:function(res){
            let posts = res.data;
            let html="";
            posts.forEach(function(post,index){
                html+=`
<tr>

<td>${index+1}</td>

<td>
<a href="detail.html?id=${post.id}">
${post.title}
</a>
</td>

<td>${post.authorName}</td>
<td>${post.viewCount}</td>
<td>${post.createdAt}</td>
</tr>
`;

            });
            $("#postTable").html(html);
        }
    });
}
