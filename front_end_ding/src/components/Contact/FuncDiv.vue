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
        <a-dropdown :trigger="['click']" style="margin-left: 1000px">
            <a class="ant-dropdown-link" @click="e => e.preventDefault()">
            <a-icon type="appstore" theme="filled" style="fontSize:32px"/>
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
            <a-menu-item key="3" >
                <a>Import Client</a>
            </a-menu-item>
            <a-menu-item key="4">
                <a>Export Client</a>
            </a-menu-item>
            <a-menu-divider />
            <a-menu-item key="5">
                <a>Create Task</a>
            </a-menu-item>
            <a-menu-item key="6">
                <a>Add in Task</a>
            </a-menu-item>
            <a-menu-divider />  
            <a-menu-item key="7">
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
    </div>
</template>
<script>
import Alert from './Alert.vue'
import InputForm from './InputForm.vue'
import EditContact from './EditContact.vue'
export default {
    namespaced: true,
    components:{
        InputForm,
        Alert,
        EditContact,
    },
    data(){
        return{
            dataSource:[],
            modal1Visible: false,
            modal2Visible: false,
            modal3Visible: false,
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
        onSelect(value) {
        console.log('onSelect', value);
        },

        handleSearch(value) {
        this.dataSource = value ? this.searchResult(value) : [];
        },

        getRandomInt(max, min = 0) {
        return Math.floor(Math.random() * (max - min + 1)) + min;
        },
        deleteclient(){
            this.$emit("deleteclient");
        },
        checkvalidselection(){
            this.$emit("checkvalidselection");
        },
        searchResult(query) {
        return new Array(this.getRandomInt(5))
            .join('.')
            .split('.')
            .map((item, idx) => ({
            query,
            category: `${query}${idx}`,
            count: this.getRandomInt(200, 100),
            }));
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
