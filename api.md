* API 文档

| api  | method  | 说明  | 返回格式  |
|---|---|---|---|
|  /api/login | post  | 用户登陆 post参数{"name":"xxx","pass":"xxx"}  | {"code":0,"message":""} 0表示用户成功登陆,message中返回token,code 1 用户不存在 code 2密码有误 3表示输入为空 |
|  /api/register |  post | 用户注册 post 参数{"name":"xxx","pass":"xxx","email":"xxx"}  | {"code":0,"message":""} 0表示注册成功 1 表示用户名已存在 2 邮箱已存在  |
|  /api/indexRecommend | get  | 获取首页推荐  | {"month":"六月","recommend":[{"foodTitle":"xxx","foodPic":"xxx(url)","foodDesc":"xxx"}...]},"hot":["foodTitle":"xxx","foodPic":"xxx(url)","foodDesc":"xxx","foodLikes":1,"foodCreateTime":"xxx","foodShare"分享的作品:"xxx","foodUrl":"xxx"}...]}|
|  /api/search?key=xxx[&page=1] | get  |  根据关键词进行搜索食品 | [{"foodTitle":"xxx","foodPic":"xxx(url)","foodDesc":"xxx","foodLikes":1,"foodCreateTime":"xxx","foodShare"分享的作品:"xxx","foodUrl":"xxx"}]  |
|  /api/getList | get  | 获取食品分类目录  | ["家常菜","快手菜"，"抖音菜"]  |
|  /api/guessLike | get  | 获取你可能喜欢的菜品  |  [{"foodTitle":"xxx","foodPic":"xxx(url)","foodDesc":"xxx","foodLikes":1,"foodCreateTime":"xxx","foodShare"分享的作品:"xxx","foodUrl":"xxx"}...] |
|  /api/myattention?token=xxx | get  |  获取关注的人的列表 | [{"name":"xxx","pic":"xxx"}...]  |
|  /api/information?name=xxx |  get | 获取某位成员的信息  |   |
|  /api/blog?name=xxx[&page=1] | get  | 获取某人的笔记列表  |  [{"foodTitle":"xxx","foodPic":"xxx(url)","foodDesc":"xxx","foodLikes":1,"foodCreateTime":"xxx","foodShare"分享的作品:"xxx","foodUrl":"xxx"}...] |
|  /api/collection？token=xxx | get  | 获取我的收藏列表  | [{"foodTitle":"xxx","foodPic":"xxx(url)","foodDesc":"xxx","foodLikes":1,"foodCreateTime":"xxx","foodShare"分享的作品:"xxx","foodUrl":"xxx"}...]  |
| /api/searchfromPeople?name=xxx&key=xxx[&page=1]  | get  | 从某人的博客里面搜索  |  [{"foodTitle":"xxx","foodPic":"xxx(url)","foodDesc":"xxx","foodLikes":1,"foodCreateTime":"xxx","foodShare"分享的作品:"xxx","foodUrl":"xxx"}...] |
| /api/foodList?class=家常菜  | get  | 根据分类寻找具体的事物  |  [{"foodTitle":"xxx","foodPic":"xxx(url)","foodDesc":"xxx","foodLikes":1,"foodCreateTime":"xxx","foodShare"分享的作品:"xxx","foodUrl":"xxx"}...] |
|  /api/foodDetail?url='' | get  | 根据foodURL获取food的详情  | {"foodTitle":"xxx","foodPic":"xxx(url)","foodDesc":"xxx","foodLikes":1,"foodCreateTime":"xxx","foodShareUrls":[{"name":"xxx","picurl"分享的:"xxx","time":"xxx","content":"xxx"}...],"foodUrl":"xxx","materials":[{"name":"xxx","quantity":"xxx"}...],"steps":[{"desc":"xxx","picurl":"xxx"}...] ,"comment":[{"name":"xxx","picurl用户头像":"xxx","time":"xxx","content":"xxx"}]|
|  /api/leaveReply?token=xxx&foodUrl=xxx&content=xxx | get  | 留下评论  | {"code":1} 0表示成功 1表示失败  |
|  /api/collect?token=xxx&foodUrl=xxx | get  | 收藏  | {"code":1} 0表示成功 1表示失败  |
|/api/like?token=xxx&foodUrl=xxx | get  | 喜欢  | {"code":1} 0表示成功 1表示失败  |
|/api/createBlog | post  | 创建 post参数……大致和上面一样……图片还不会等等  | {"code":1} 0表示成功 1表示失败  |
|/api/changeInfo | post  | 修改个人信息 name,location,sex,brithday,email  | {"code":1} 0表示成功 1表示失败  |
| /api/changeUserPic?token=xxx | post | 修改个人头像| {"code":1} 0表示成功 1表示失败  |

