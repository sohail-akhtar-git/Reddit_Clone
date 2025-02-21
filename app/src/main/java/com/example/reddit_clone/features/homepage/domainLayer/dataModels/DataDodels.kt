package com.example.reddit_clone.features.homepage.domainLayer.dataModels

data class Post(
    val title:String,
    val author: Author,
    val postItems:Array<String>,
    var likeCount:Int,
    var comentsCount:Int,
    var uploadTime:String,
    var comments:Array<PostComment>
)

data class Author(
    val userName:String,
    val profilePic:String,
)

data class PostComment(
    val author: Author,
    val comment: String,
)

val postList = arrayOf(
    Post(
        title = "It's been 5 days since this issue and I haven't found any solution",
        author = Author(
            userName = "r/Weird",
            profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
        ),
        postItems = arrayOf("https://preview.redd.it/how-did-you-get-that-big-v0-8ikrpwza6uje1.png?auto=webp&s=8ec2e66aecf45bf8e73a8d7fcf4d5047d818b5dc", "https://preview.redd.it/trumpflation-v0-yi85v5qflsje1.jpeg?auto=webp&s=95bb4282ad26c915c0674c861d0fded13c9882dc", "https://preview.redd.it/perfect-timing-v0-mv2ietxyhuje1.jpeg?auto=webp&s=f127256ec7a1e6787c097c8f7f7bfdba80aafbdc"),
        likeCount = 2000,
        comentsCount = 765,
        uploadTime = "2 days Ago",
        comments = arrayOf(
            PostComment(
                author = Author(
                    userName = "r/Weird",
                    profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
                ),
                comment = "Good"
            )
        )
    ),
    Post(
        title = "Facing strange behavior with my device after latest update",
        author = Author(
            userName = "r/TechSupport",
            profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
        ),
        postItems = arrayOf("https://preview.redd.it/how-did-you-get-that-big-v0-8ikrpwza6uje1.png?auto=webp&s=8ec2e66aecf45bf8e73a8d7fcf4d5047d818b5dc", "https://preview.redd.it/trumpflation-v0-yi85v5qflsje1.jpeg?auto=webp&s=95bb4282ad26c915c0674c861d0fded13c9882dc", "https://preview.redd.it/perfect-timing-v0-mv2ietxyhuje1.jpeg?auto=webp&s=f127256ec7a1e6787c097c8f7f7bfdba80aafbdc"),
        likeCount = 1500,
        comentsCount = 432,
        uploadTime = "1 day Ago",
        comments = arrayOf(
            PostComment(
                author = Author(
                    userName = "r/Techie",
                    profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
                ),
                comment = "Did you try restarting it?"
            )
        )
    ),
    Post(
        title = "Facing strange behavior with my device after latest update",
        author = Author(
            userName = "r/TechSupport",
            profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
        ),
        postItems = arrayOf("https://preview.redd.it/how-did-you-get-that-big-v0-8ikrpwza6uje1.png?auto=webp&s=8ec2e66aecf45bf8e73a8d7fcf4d5047d818b5dc", "https://preview.redd.it/trumpflation-v0-yi85v5qflsje1.jpeg?auto=webp&s=95bb4282ad26c915c0674c861d0fded13c9882dc", "https://preview.redd.it/perfect-timing-v0-mv2ietxyhuje1.jpeg?auto=webp&s=f127256ec7a1e6787c097c8f7f7bfdba80aafbdc"),
        likeCount = 1500,
        comentsCount = 432,
        uploadTime = "1 day Ago",
        comments = arrayOf(
            PostComment(
                author = Author(
                    userName = "r/Techie",
                    profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
                ),
                comment = "Did you try restarting it?"
            )
        )
    ),
    Post(
        title = "Facing strange behavior with my device after latest update",
        author = Author(
            userName = "r/TechSupport",
            profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
        ),
        postItems = arrayOf("https://preview.redd.it/how-did-you-get-that-big-v0-8ikrpwza6uje1.png?auto=webp&s=8ec2e66aecf45bf8e73a8d7fcf4d5047d818b5dc", "https://preview.redd.it/trumpflation-v0-yi85v5qflsje1.jpeg?auto=webp&s=95bb4282ad26c915c0674c861d0fded13c9882dc", "https://preview.redd.it/perfect-timing-v0-mv2ietxyhuje1.jpeg?auto=webp&s=f127256ec7a1e6787c097c8f7f7bfdba80aafbdc"),
        likeCount = 1500,
        comentsCount = 432,
        uploadTime = "1 day Ago",
        comments = arrayOf(
            PostComment(
                author = Author(
                    userName = "r/Techie",
                    profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
                ),
                comment = "Did you try restarting it?"
            )
        )
    ),
    Post(
        title = "Facing strange behavior with my device after latest update",
        author = Author(
            userName = "r/TechSupport",
            profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
        ),
        postItems = arrayOf("https://preview.redd.it/how-did-you-get-that-big-v0-8ikrpwza6uje1.png?auto=webp&s=8ec2e66aecf45bf8e73a8d7fcf4d5047d818b5dc", "https://preview.redd.it/trumpflation-v0-yi85v5qflsje1.jpeg?auto=webp&s=95bb4282ad26c915c0674c861d0fded13c9882dc", "https://preview.redd.it/perfect-timing-v0-mv2ietxyhuje1.jpeg?auto=webp&s=f127256ec7a1e6787c097c8f7f7bfdba80aafbdc"),
        likeCount = 1500,
        comentsCount = 432,
        uploadTime = "1 day Ago",
        comments = arrayOf(
            PostComment(
                author = Author(
                    userName = "r/Techie",
                    profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
                ),
                comment = "Did you try restarting it?"
            )
        )
    ),
    Post(
        title = "Facing strange behavior with my device after latest update",
        author = Author(
            userName = "r/TechSupport",
            profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
        ),
        postItems = arrayOf("https://preview.redd.it/how-did-you-get-that-big-v0-8ikrpwza6uje1.png?auto=webp&s=8ec2e66aecf45bf8e73a8d7fcf4d5047d818b5dc", "https://preview.redd.it/trumpflation-v0-yi85v5qflsje1.jpeg?auto=webp&s=95bb4282ad26c915c0674c861d0fded13c9882dc", "https://preview.redd.it/perfect-timing-v0-mv2ietxyhuje1.jpeg?auto=webp&s=f127256ec7a1e6787c097c8f7f7bfdba80aafbdc"),
        likeCount = 1500,
        comentsCount = 432,
        uploadTime = "1 day Ago",
        comments = arrayOf(
            PostComment(
                author = Author(
                    userName = "r/Techie",
                    profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
                ),
                comment = "Did you try restarting it?"
            )
        )
    ),
    Post(
        title = "Facing strange behavior with my device after latest update",
        author = Author(
            userName = "r/TechSupport",
            profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
        ),
        postItems = arrayOf("https://preview.redd.it/how-did-you-get-that-big-v0-8ikrpwza6uje1.png?auto=webp&s=8ec2e66aecf45bf8e73a8d7fcf4d5047d818b5dc", "https://preview.redd.it/trumpflation-v0-yi85v5qflsje1.jpeg?auto=webp&s=95bb4282ad26c915c0674c861d0fded13c9882dc", "https://preview.redd.it/perfect-timing-v0-mv2ietxyhuje1.jpeg?auto=webp&s=f127256ec7a1e6787c097c8f7f7bfdba80aafbdc"),
        likeCount = 1500,
        comentsCount = 432,
        uploadTime = "1 day Ago",
        comments = arrayOf(
            PostComment(
                author = Author(
                    userName = "r/Techie",
                    profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
                ),
                comment = "Did you try restarting it?"
            )
        )
    ),
    Post(
        title = "Facing strange behavior with my device after latest update",
        author = Author(
            userName = "r/TechSupport",
            profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
        ),
        postItems = arrayOf("https://preview.redd.it/how-did-you-get-that-big-v0-8ikrpwza6uje1.png?auto=webp&s=8ec2e66aecf45bf8e73a8d7fcf4d5047d818b5dc", "https://preview.redd.it/trumpflation-v0-yi85v5qflsje1.jpeg?auto=webp&s=95bb4282ad26c915c0674c861d0fded13c9882dc", "https://preview.redd.it/perfect-timing-v0-mv2ietxyhuje1.jpeg?auto=webp&s=f127256ec7a1e6787c097c8f7f7bfdba80aafbdc"),
        likeCount = 1500,
        comentsCount = 432,
        uploadTime = "1 day Ago",
        comments = arrayOf(
            PostComment(
                author = Author(
                    userName = "r/Techie",
                    profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
                ),
                comment = "Did you try restarting it?"
            )
        )
    ),
    Post(
        title = "Facing strange behavior with my device after latest update",
        author = Author(
            userName = "r/TechSupport",
            profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
        ),
        postItems = arrayOf("https://preview.redd.it/how-did-you-get-that-big-v0-8ikrpwza6uje1.png?auto=webp&s=8ec2e66aecf45bf8e73a8d7fcf4d5047d818b5dc", "https://preview.redd.it/trumpflation-v0-yi85v5qflsje1.jpeg?auto=webp&s=95bb4282ad26c915c0674c861d0fded13c9882dc", "https://preview.redd.it/perfect-timing-v0-mv2ietxyhuje1.jpeg?auto=webp&s=f127256ec7a1e6787c097c8f7f7bfdba80aafbdc"),
        likeCount = 1500,
        comentsCount = 432,
        uploadTime = "1 day Ago",
        comments = arrayOf(
            PostComment(
                author = Author(
                    userName = "r/Techie",
                    profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
                ),
                comment = "Did you try restarting it?"
            )
        )
    ),
    Post(
        title = "Facing strange behavior with my device after latest update",
        author = Author(
            userName = "r/TechSupport",
            profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
        ),
        postItems = arrayOf("https://preview.redd.it/how-did-you-get-that-big-v0-8ikrpwza6uje1.png?auto=webp&s=8ec2e66aecf45bf8e73a8d7fcf4d5047d818b5dc", "https://preview.redd.it/trumpflation-v0-yi85v5qflsje1.jpeg?auto=webp&s=95bb4282ad26c915c0674c861d0fded13c9882dc", "https://preview.redd.it/perfect-timing-v0-mv2ietxyhuje1.jpeg?auto=webp&s=f127256ec7a1e6787c097c8f7f7bfdba80aafbdc"),
        likeCount = 1500,
        comentsCount = 432,
        uploadTime = "1 day Ago",
        comments = arrayOf(
            PostComment(
                author = Author(
                    userName = "r/Techie",
                    profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
                ),
                comment = "Did you try restarting it?"
            )
        )
    ),
    Post(
        title = "Facing strange behavior with my device after latest update",
        author = Author(
            userName = "r/TechSupport",
            profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
        ),
        postItems = arrayOf("https://preview.redd.it/how-did-you-get-that-big-v0-8ikrpwza6uje1.png?auto=webp&s=8ec2e66aecf45bf8e73a8d7fcf4d5047d818b5dc", "https://preview.redd.it/trumpflation-v0-yi85v5qflsje1.jpeg?auto=webp&s=95bb4282ad26c915c0674c861d0fded13c9882dc", "https://preview.redd.it/perfect-timing-v0-mv2ietxyhuje1.jpeg?auto=webp&s=f127256ec7a1e6787c097c8f7f7bfdba80aafbdc"),
        likeCount = 1500,
        comentsCount = 432,
        uploadTime = "1 day Ago",
        comments = arrayOf(
            PostComment(
                author = Author(
                    userName = "r/Techie",
                    profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
                ),
                comment = "Did you try restarting it?"
            )
        )
    ),
    Post(
        title = "Facing strange behavior with my device after latest update",
        author = Author(
            userName = "r/TechSupport",
            profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
        ),
        postItems = arrayOf("https://preview.redd.it/how-did-you-get-that-big-v0-8ikrpwza6uje1.png?auto=webp&s=8ec2e66aecf45bf8e73a8d7fcf4d5047d818b5dc", "https://preview.redd.it/trumpflation-v0-yi85v5qflsje1.jpeg?auto=webp&s=95bb4282ad26c915c0674c861d0fded13c9882dc", "https://preview.redd.it/perfect-timing-v0-mv2ietxyhuje1.jpeg?auto=webp&s=f127256ec7a1e6787c097c8f7f7bfdba80aafbdc"),
        likeCount = 1500,
        comentsCount = 432,
        uploadTime = "1 day Ago",
        comments = arrayOf(
            PostComment(
                author = Author(
                    userName = "r/Techie",
                    profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
                ),
                comment = "Did you try restarting it?"
            )
        )
    ),
    Post(
        title = "Facing strange behavior with my device after latest update",
        author = Author(
            userName = "r/TechSupport",
            profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
        ),
        postItems = arrayOf("https://preview.redd.it/how-did-you-get-that-big-v0-8ikrpwza6uje1.png?auto=webp&s=8ec2e66aecf45bf8e73a8d7fcf4d5047d818b5dc", "https://preview.redd.it/trumpflation-v0-yi85v5qflsje1.jpeg?auto=webp&s=95bb4282ad26c915c0674c861d0fded13c9882dc", "https://preview.redd.it/perfect-timing-v0-mv2ietxyhuje1.jpeg?auto=webp&s=f127256ec7a1e6787c097c8f7f7bfdba80aafbdc"),
        likeCount = 1500,
        comentsCount = 432,
        uploadTime = "1 day Ago",
        comments = arrayOf(
            PostComment(
                author = Author(
                    userName = "r/Techie",
                    profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
                ),
                comment = "Did you try restarting it?"
            )
        )
    ),
    Post(
        title = "Facing strange behavior with my device after latest update",
        author = Author(
            userName = "r/TechSupport",
            profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
        ),
        postItems = arrayOf("https://preview.redd.it/how-did-you-get-that-big-v0-8ikrpwza6uje1.png?auto=webp&s=8ec2e66aecf45bf8e73a8d7fcf4d5047d818b5dc", "https://preview.redd.it/trumpflation-v0-yi85v5qflsje1.jpeg?auto=webp&s=95bb4282ad26c915c0674c861d0fded13c9882dc", "https://preview.redd.it/perfect-timing-v0-mv2ietxyhuje1.jpeg?auto=webp&s=f127256ec7a1e6787c097c8f7f7bfdba80aafbdc"),
        likeCount = 1500,
        comentsCount = 432,
        uploadTime = "1 day Ago",
        comments = arrayOf(
            PostComment(
                author = Author(
                    userName = "r/Techie",
                    profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
                ),
                comment = "Did you try restarting it?"
            )
        )
    ),
    Post(
        title = "Facing strange behavior with my device after latest update",
        author = Author(
            userName = "r/TechSupport",
            profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
        ),
        postItems = arrayOf("https://preview.redd.it/how-did-you-get-that-big-v0-8ikrpwza6uje1.png?auto=webp&s=8ec2e66aecf45bf8e73a8d7fcf4d5047d818b5dc", "https://preview.redd.it/trumpflation-v0-yi85v5qflsje1.jpeg?auto=webp&s=95bb4282ad26c915c0674c861d0fded13c9882dc", "https://preview.redd.it/perfect-timing-v0-mv2ietxyhuje1.jpeg?auto=webp&s=f127256ec7a1e6787c097c8f7f7bfdba80aafbdc"),
        likeCount = 1500,
        comentsCount = 432,
        uploadTime = "1 day Ago",
        comments = arrayOf(
            PostComment(
                author = Author(
                    userName = "r/Techie",
                    profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
                ),
                comment = "Did you try restarting it?"
            )
        )
    ),
    Post(
        title = "Facing strange behavior with my device after latest update",
        author = Author(
            userName = "r/TechSupport",
            profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
        ),
        postItems = arrayOf("https://preview.redd.it/how-did-you-get-that-big-v0-8ikrpwza6uje1.png?auto=webp&s=8ec2e66aecf45bf8e73a8d7fcf4d5047d818b5dc", "https://preview.redd.it/trumpflation-v0-yi85v5qflsje1.jpeg?auto=webp&s=95bb4282ad26c915c0674c861d0fded13c9882dc", "https://preview.redd.it/perfect-timing-v0-mv2ietxyhuje1.jpeg?auto=webp&s=f127256ec7a1e6787c097c8f7f7bfdba80aafbdc"),
        likeCount = 1500,
        comentsCount = 432,
        uploadTime = "1 day Ago",
        comments = arrayOf(
            PostComment(
                author = Author(
                    userName = "r/Techie",
                    profilePic = "https://b.thumbs.redditmedia.com/y0FEEr4SU2yB-g8D0qh1Clu-AwPmCaX9PAgOWuO6vIs.png"
                ),
                comment = "Did you try restarting it?"
            )
        )
    )
)

