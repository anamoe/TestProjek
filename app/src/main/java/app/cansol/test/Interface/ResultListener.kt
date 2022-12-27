package app.cansol.test.Interface

/**
 * Interface used proived result on specific occasion**/
interface ResultListener {
    fun onSuccess(message:String)
    fun onFailure(message: String)
}