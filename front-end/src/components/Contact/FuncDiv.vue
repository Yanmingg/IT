<template>
    <div>
        <Alert ref="Alert"></Alert>
        <a-space>
        <a-auto-complete
            class="global-search"
            size="large"
            style="width: 100%"
            placeholder="input here"
            option-label-prop="title"
            @select="onSelect"
            @search="handleSearch"
        >
            <template slot="dataSource">
            <a-select-option v-for="item in dataSource" :key="item.category" :title="item.category">
                Found {{ item.query }} on
                <a
                :href="`https://s.taobao.com/search?q=${item.query}`"
                target="_blank"
                rel="noopener noreferrer"
                >
                {{ item.category }}
                </a>
                <span className="global-search-item-count">{{ item.count }} results</span>
            </a-select-option>
            </template>
            <a-input>
            <a-button
                slot="suffix"
                style="margin-right: -12px"
                class="search-btn"
                size="large"
                type="link"
            >
                <a-icon type="search" />
            </a-button>
            </a-input>
        </a-auto-complete>
        <a-dropdown :trigger="['click']" style="margin-left: 1500px">
            <a class="ant-dropdown-link" @click="e => e.preventDefault()">
            <a-icon type="appstore" theme="filled" style="fontSize:50px"/>
            </a>
            <a-menu slot="overlay">
            <a-menu-item key="0" @click="setModal1Visible(true)">
                <a>Create Client</a>
            </a-menu-item>
            <a-menu-item key="1" @click="setModal2Visible(true);">
                <a>Delete Client</a>
            </a-menu-item>
            <a-menu-item key="2" @click="checkvalidselection()">
                <a>Change Detail</a>
            </a-menu-item>
            <a-menu-divider />
 
            <a-menu-item key="5" @click="setModal4Visible(true);">
                <a>Send Email</a>
            </a-menu-item>
            </a-menu>
        </a-dropdown>
        </a-space>
        <a-modal
        title="Create Client"
        :dialog-style="{ top: '20px' }"
        okText = 'Submit'
        :visible="modal1Visible"
        centered
        @ok="submitRecord()"
        @cancel="cancelSubmit()"
        >
            <InputForm 
                ref="createRecord" 
                v-on={getrecord:getrecord,setModal1Visible:setModal1Visible}
            >
            </InputForm>
        </a-modal>
        <a-modal
        title="Delete Client"
        :dialog-style="{ top: '20px' }"
        :visible="modal2Visible"
        centered
        okText = 'Comfirm'
        @ok="setModal2Visible(false);deleteclient()"
        @cancel="setModal2Visible(false);"
        >
        <div style="overflow-y:auto">
            <div>Do u really want to delete this contact?</div>
        </div>
        
        </a-modal>
        <a-modal
        title="Edit Detail"
        :dialog-style="{ top: '20px' }"
        :visible="modal3Visible"
        centered
        okText = 'Submit'
        @ok="setModal3Visible(false);editContact()"
        @cancel="setModal3Visible(false);"
        >
            <EditContact 
                ref="edit"
                v-on={editRecord:editRecord,setModal3Visible:setModal1Visible}
            >
            </EditContact>    
        </a-modal>
         <a-modal
        title="Send Email"
        :dialog-style="{ top: '20px' }"
        :visible="modal4Visible"
        centered
        okText = 'Send'
        @ok="sendEmail()"
        @cancel="setModal4Visible(false);"
        >
            <SendEmail
                ref="sendEmail"
                v-on={setModal4Visible:setModal4Visible}
            >
            </SendEmail>    
        </a-modal>
    </div>
</template>
<script>
import Alert from './Alert.vue'
import InputForm from './InputForm.vue'
import EditContact from './EditContact.vue'
import SendEmail from './SendEmail.vue'
export default {
    namespaced: true,
    components:{
        InputForm,
        Alert,
        EditContact,
        SendEmail,
    },
    data(){
        return{
          
url: {
	downloadUrl: '/file/contact.csv',
},
            dataSource:[],
            modal1Visible: false,
            modal2Visible: false,
            modal3Visible: false,
            modal4Visible: false,
        }
    },
    methods: {
        setModal1Visible(modalVisible) {
            this.modal1Visible = modalVisible;
        },
        setModal2Visible(modalVisible) {
            this.modal2Visible = modalVisible;
        },
        setModal3Visible(modalVisible) {
            this.modal3Visible = modalVisible;
        },
        setModal4Visible(modalVisible) {
            this.modal4Visible = modalVisible;
        },
        sendEmail(){
            this.$refs.sendEmail.handlesubmit();
        },
        onSelect(value) {
        console.log('onSelect', value);
        },



        handleSearch(value) {
            console.log(value)
            if(value == ""){
                  this.$store.dispatch('contact/getAllContact',localStorage.getItem("userid"))//在store里调用getAllContact函数  dispatch是调用acction的
            }
            this.$store.dispatch("contact/searchContact", value);
        //this.dataSource = value ? this.searchResult(value) : [];
        },




        deleteclient(){
            this.$emit("deleteclient");
        },
        checkvalidselection(){
            this.$emit("checkvalidselection");
        },
        getrecord(values){
            this.$emit("createclient",values);
        },
        submitRecord(){
            this.$refs.createRecord.handlesubmit();

        },
        cancelSubmit(){
            this.setModal1Visible(false);
            this.$refs.createRecord.resetForm();
        },
        postContact(contact){
            this.setModal3Visible(true);
            setTimeout(()=>{
                this.$refs.edit.getContact(contact);
            },10)
        },
        showAlert(msg){
            this.$refs.Alert.handleOpen(msg);
        },
        editContact(){
            this.$refs.edit.handlesubmit();
        },
        editRecord(values,id){
            this.$emit("editclient",values,id);
        }
    },
}
</script>
