package org.sopt24.dshyun0226.androidseminar.Network.Post

data class PostLoginResponse (
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : String? // data는 String 타입이지만 NULL값이 들어갈 수 있기 때문에 ? 붙여줘야 됨
)