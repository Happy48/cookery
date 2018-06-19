* API 文档

| api  | method  | 说明  | 返回格式  |
|---|---|---|---|
|  /api/login | post  | 用户登陆 post参数{"name":"xxx","pass":"xxx"}  | {"code":0,"message":""} 0表示用户成功登陆,message中返回token,code 1 用户不存在 code 2密码有误 3表示输入为空 |
|  /api/register |  post | 用户注册 post 参数{"name":"xxx","pass":"xxx","email":"xxx"}  | {"code":0} 0表示注册成功 1 表示用户名已存在 2 邮箱已存在  |
|  /api/indexRecommend | get  | 获取首页推荐  | {"month":"六月","recommend":[{"foodTitle":"xxx","foodPic":"xxx(url)","foodDesc":"xxx"}...]},"hot":["foodTitle":"xxx","foodPic":"xxx(url)","foodDesc":"xxx","foodLikes":1,"foodCreateTime":"xxx","foodShare"分享的作品:"xxx","foodUrl":"xxx"}...]}|
|  /api/search?key=xxx[&page=1] | get  |  根据关键词进行搜索食品 | [{"foodTitle":"xxx","foodPic":"xxx(url)","foodDesc":"xxx","foodLikes":1,"foodCreateTime":"xxx","foodShare"分享的作品:"xxx","foodUrl":"xxx"}]  |
|  /api/getList | get  | 获取食品分类目录  | [{"id":"1","name":"家常菜"}...]  |
|  /api/guessLike | get  | 获取你可能喜欢的菜品  |  [{"foodTitle":"xxx","foodPic":"xxx(url)","foodDesc":"xxx","foodLikes":1,"foodCreateTime":"xxx","foodCollect":1,"noteId":12}...] |
|  /api/myFollowList?token=xxx | get  |  获取关注的人的列表 | [{"name":"xxx","icon":"xxx"}...]  |
|  /api/userInfo?name=xxx |  get |  获取某位成员的信息  | [{"userId":12,"userName":"xxx","sex":0,"introduction":"xxx","icon":"xxx"}]    |
   /api/userInfo?token=xxx |  get |  获取某位成员的信息  | [{"userId":12,"userName":"xxx","sex":0,"introduction":"xxx","icon":"xxx"}]    |
|  /api/userNoteList?name=xxx[&page=1] | get  | 获取某人的笔记列表  |  [{"foodTitle":"xxx","foodPic":"xxx(url)","foodDesc":"xxx","foodLikes":1,"foodCreateTime":"xxx","foodCollect":"1,"noteId":12}...] |
|  /api/userCollection?token=xxx | get  | 获取我的收藏列表  | [{"foodTitle":"xxx","foodPic":"xxx(url)","foodDesc":"xxx","foodLikes":1,"foodCreateTime":"xxx","foodCollect":2,"noteId":12}...]  |
| /api/searchFromPeople?name=xxx&key=xxx[&page=1]  | get  | 从某人的博客里面搜索  |  [{"foodTitle":"xxx","foodPic":"xxx(url)","foodDesc":"xxx","foodLikes":1,"foodCreateTime":"xxx","foodCollect":2,"noteId":12}...] |
| /api/getNoteList?class=1  | get  | 根据分类寻找具体的事物  |  [{"foodTitle":"xxx","foodPic":"xxx(url)","foodDesc":"xxx","foodLikes":1,"foodCreateTime":"xxx","foodCollect":2,"noteId":12}...] |
|  /api/getNoteDetail?noteId=xxx | get  | 根据noteId获取food的详情  | {"foodTitle":"xxx","foodPic":"xxx(url)","foodDesc":"xxx","foodLikes":1,"foodCreateTime":"xxx","workVOList":[{"userId":12,"picture":"xxx","desc":"xxx"}...],"noteId":12,"materialVOList":[{"name":"xxx","quantity":"xxx"}...],"stepVOList":[{"desc":"xxx","picUrl":"xxx"}...] ,"commentVOList":[{"userId":1,"time":"xxx","content":"xxx"}]|
|  /api/leaveReply?token=xxx&noteId=xxx&content=xxx | post  | 留下评论  | {"code":1} 0表示成功 1表示失败  |
|  /api/collect?token=xxx&noteid=xxx | get  | 收藏  | {"code":1} 0表示成功 1已有该收藏，取消收藏 2表示用户不存在  |
|/api/like?token=xxx&noteid=xxx | get  | 喜欢  | {"code":1} 0表示成功 1已有该喜欢，取消喜欢 2表示用户不存在  |
|/api/createNote | post  | 添加新笔记 token，noteName,noteCover,description,material,practice,tip,subtag(如"家常菜，下饭菜"，逗号隔开分类)  | {"code":1} 0表示成功 1表示子标签不在subtag范围之内 2表示用户不存在  |
|/api/changeInfo | post  | 修改个人信息 token,userName,address,sex,birthday,introduction,phoneNumber,userPwd,email  | {"code":1} 0表示成功 1表示修改的用户名已存在 2表示修改的邮箱已存在 3表示用户不存在  |
| /api/changeUserPic?token=xxx | post | 修改个人头像| {"code":1} 0表示成功 1表示失败  |
| /api/isLike?token=xxx&noteid=xxx |get|{"code":1} 0表示已经有喜欢 1表示还未喜欢 2表示用户不存在  |
| /api/isCollect?token=xxx&noteid=xxx |get|{"code":1} 0表示已经收藏 1表示还未收藏 2表示用户不存在  |
| /api/searchMyBlog?token=xxx&key=xxx[&page=1]  | get  | 从个人的博客里面搜索  |  [{"foodTitle":"xxx","foodPic":"xxx(url)","foodDesc":"xxx","foodLikes":1,"foodCreateTime":"xxx","foodCollect":2,"noteId":12}...] |
| /api/myNoteList?token=xxx[&page=1] | get  | 获取我的笔记列表  |  [{"foodTitle":"xxx","foodPic":"xxx(url)","foodDesc":"xxx","foodLikes":1,"foodCreateTime":"xxx","foodCollect":"1,"noteId":12}...] |
