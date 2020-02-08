package com.kaungmyatmin.wonder.utli

import android.util.Log
import org.json.JSONException
import org.json.JSONObject

class ErrorHandling{

    companion object{

        private val TAG: String = "AppDebug"

        const val UNABLE_TO_RESOLVE_HOST = "Unable to resolve host"
        const val PAGINATION_DONE_ERROR = "Invalid page."
        const val ERROR_CHECK_NETWORK_CONNECTION = "Check network connection."


        fun isNetworkError(msg: String): Boolean{
            when{
                msg.contains(UNABLE_TO_RESOLVE_HOST) -> return true
                else-> return false
            }
        }

        fun parseDetailJsonResponse(rawJson: String?): String{
            Log.d(TAG, "parseDetailJsonResponse: ${rawJson}")
            try{
                if(!rawJson.isNullOrBlank()){
                    if(rawJson.equals(ERROR_CHECK_NETWORK_CONNECTION)){
                        return PAGINATION_DONE_ERROR
                    }
                    return JSONObject(rawJson).get("detail") as String
                }
            }catch (e: JSONException){
                Log.e(TAG, "parseDetailJsonResponse: ${e.message}")
            }
            return ""
        }

        fun isPaginationDone(errorResponse: String?): Boolean{
            // if error response = '{"detail":"Invalid page."}' then pagination is finished
            return PAGINATION_DONE_ERROR.equals(parseDetailJsonResponse(errorResponse))
        }
    }

}