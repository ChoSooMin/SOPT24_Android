package org.sopt24.dshyun0226.androidseminar.Data

data class ProductOverviewData( // 서버에서 보내주는 이름대로 바꿔야 함
    var thumnail: String,
    var product_id: Int,
    var title: String,
    var likes: Int,
    var name: String,
    var isFinished: Int
)


