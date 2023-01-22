package com.zahid.projectmanager.activities.utils

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.webkit.MimeTypeMap
import com.zahid.projectmanager.activities.MyProfileActivity

object Constants {
    const val USERS: String = "users"
    const val IMAGE: String = "image"
    const val NAME: String = "name"
    const val MOBILE: String = "mobile"
    const val BOARDS: String = "boards"
    const val ASSIGNED_TO:String = "assignedTo"
    const val DOCUMENT_ID:String = "documentId"
    const val TASK_LIST: String = "taskList"
    const val BOARD_DETAIL: String = "board_detail"
    const val ID:String = "id"
    const val EMAIL:String = "email"
    const val TASK_LIST_ITEM_POSITION: String = "task_list_item_position"
    const val CARD_LIST_ITEM_POSITION: String = "card_list_item_position"
    const val BOARD_MEMBERS_LIST:String = "boardMemberList"
    const val SELECT: String = "Select"
    const val UN_SELECT: String = "UnSelect"
    const val PROGEMANAG_PREFERENCES: String = "ProjemanagPrefs"
    const val FCM_TOKEN:String = "fcmToken"
    const val FCM_TOKEN_UPDATED:String = "fcmTokenUpdated"
    const val PICK_IMAGE_REQUEST_CODE = 2
    const val READ_STORAGE_PERMISSION_CODE = 1
    const val FCM_BASE_URL:String = "https://fcm.googleapis.com/fcm/send"
    const val FCM_AUTHORIZATION:String = "authorization"
    const val FCM_KEY:String = "key"
    const val FCM_SERVER_KEY:String = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQD6+hnnw84NvE5J\\n99XBzqR/fwKXzb/nZp0lmDLqosEiFQjGswa0x7PqiwydRjTyR7FeFWIikIKzXEv1\\n/ugrQfyIsWjVOypgdv0z+4hamcBjcn63hBHufGrzSS7hT9pWan9ktEpkapTxD1os\\noT9b9FQAZ/3jt5MRhv+G2xRVOqVFPX3HPL5El1eu7BsM5lLPYmDnusYYOKP/6bUL\\ndXLD+O+bgPvhLWYcY/F9HID4Xg4s6QUCN671HXKtRBj/IvUPlI343pDAr/1DyUSC\\nuC9hOzc+8r90tXqb0q14xMF6afxmSFSeuCgIjZoyVcZe7ado7ZRBRGVCw51XCFQQ\\nihq6cAQnAgMBAAECggEAMb7s75FSAEr4wZSMG/QXiuXj3676gKVINLFsNjG4UkcV\\nDD1j8OU8dhrFj07hI7yuHVXjs7ItFdwPelziK+DSa02u18T4a1JqcalDp6GeDpgd\\nIcbdvwWONVamIiavwj0trwpFTI4Lo5RFbV8wrctJ8yKpoj86uVimwVYfO516MLTR\\nApLAI1bh6ijBa/dW+eNcn+eau8ApGNx6/4YaKphW/BcW8+z2gTg+qSi8t6M29Etn\\nHyvt3pmtXugwKKQl+HSDaEMxyVeB13Jc5U1uM0ktWQAEJEKR/psbKmHji6xV8FYs\\nstaSWpz3AbJFYGTvknbyzmNldzDNl0CjMUzWo60nQQKBgQD/vaii1awJnHPOzMJl\\nWAjx0vZDZ+XIKRao9+NPRVKDoY0ZGvfXTfSm+skWA1ahw+8X6qV7fuWfuaZaFRrk\\nGAN1So+a6Qt52T0KCKgCOcd/vyy1Kvb1p99y6dlTLBpv87eabny4cZlgnpjKB4Qk\\nFjWx/8fmtKscBBITaJQjAdJLkQKBgQD7OzTn9KJIptqbYardovmbKVZzkO6H8aye\\n0XNIaavejA/311s6422ZO4JS8jFFPcU9aIxOxBJNNIqRsFyFOq5OOwIFesFrq2u0\\nUKG0xEvbFlnnC7DqipyZZpPQGl07tmVt5opmYfRPrQR2l+2h68GYIR9mL2BX28RE\\nAfHKdnFINwKBgQD25Pz3J12NcdOD5L4P5OvNuqMw9A8sLC7KNXbnwr8kgUSc5iI7\\nY/E7e4XCkLqENYqQBmJ4VUwN5ccp1JI/fsdn5vG41h/UJNv+4diBPZLSS5g31yDQ\\njJ72a7j5yOxFBH9Owjf6QQGX+8T51kPGKwLvs0Yj/mvrAisJPb82BL4nYQKBgQDz\\nm0mF0dS6lfBL0ryYBTv7lG3byaFB+Lnlljsu8ChTt4SUUiKIS5cuimGohGf6OBdV\\noFbM2ZrVeikTc+uC1I/IE7e2EH4VJTdetQDYA696VYX/X3rBMn7+0FRr6eSVzhs0\\nIeP5uunniGFXjaJC7BPgq92CfFXzW4pIV4pZQ9g8qQKBgQCJNEqha1J8Jq1vmiaA\\n0sJirYJpyGfjyWn6J+j8pdO6OCDjiww3fp+RM4xV7n+7OJt9+gOl485rjKARyAz9\\nN0JrakjSZXETxxodchcH1YQPa0NlPrsFPDfCVw9a8o0/lunBficZaoisgF7IK4KA\\ned9K7+V2IuSMJ9zj5mB17hpC2g=="
    const val FCM_KEY_TITLE:String = "title"
    const val FCM_KEY_MESSAGE:String = "message"
    const val FCM_KEY_DATA:String = "data"
    const val FCM_KEY_TO:String = "to"
    fun getFileExtension(activity: Activity,uri: Uri?):String?{
        return MimeTypeMap.getSingleton().getExtensionFromMimeType(uri?.let {
            activity.contentResolver.getType(
                it
            )
        })

    }
    fun showImageChooser(activity:Activity) {
        // An intent for launching the image selection of phone storage.
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        // Launches the image selection of phone storage using the constant code.
        activity.startActivityForResult(galleryIntent,PICK_IMAGE_REQUEST_CODE)
    }
}