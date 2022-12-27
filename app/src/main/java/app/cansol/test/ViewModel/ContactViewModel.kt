package app.cansol.test.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import app.cansol.test.Model.Contact
import app.cansol.test.Repository.ContactRepository

/**
 * ViewModel class one of the component of MVVM
 * it communicate with repository
 * and also provide necessary data UI to display accordingly
 **/
class ContactViewModel(id:String): ViewModel() {
    private var repository:ContactRepository = ContactRepository()
    private var allContact:LiveData<List<Contact>>

    fun list():LiveData<List<Contact>>{
        return  allContact
    }

    init{
        repository = ContactRepository()
        allContact = repository.getAllContacts(id)

    }

    fun createContact(contact:Contact,userId:String){
        allContact = repository.createContact(contact,userId)

    }

    fun updateContact(contact:Contact,userId:String){
        allContact = repository.updateContact(contact,userId)

    }

    fun deleteContact(contact:Contact,userId:String){
        allContact = repository.deleteCont(userId,contact)

    }
}