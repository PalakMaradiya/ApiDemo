package com.example.apicallappication.RESPONSE

import com.google.gson.annotations.SerializedName

data class ObjectRespone(

	@field:SerializedName("ObjectRespone")
	val objectRespone: List<ObjectResponeItem?>? = null
)

data class ObjectResponeItem(

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
