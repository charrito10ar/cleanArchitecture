package com.nicequest.nicequesttest.data.bodies

class ResponseToken(var access_token: String,
                    var expires_in: Int,
                    var token_type: String,
                    var scope: String,
                    var refresh_token: String,
                    var account_id: String,
                    var account_username: String)