<template>
<div>
    <!-- <h1>{{info[0].id}}</h1> -->
    <v-col></v-col>
    <!-- <v-data-table :headers="headers" :items="desserts" :search="search" sort-by="calories" class="elevation-1">
        <template v-slot:top>
            <v-toolbar flat color="#00796B">
                <v-toolbar-title class="white--text">Employee List</v-toolbar-title>
                <v-divider class="mx-4" inset vertical></v-divider>
                <v-text-field background-color="white" prepend-inner-icon="mdi-magnify" label="Search" single-line hide-details></v-text-field>
                <v-spacer></v-spacer>
                <v-dialog v-model="dialog" max-width="500px">
                    <template v-slot:activator="{ on, attrs }">
                        <v-btn color="#64B5F6" dark class="mb-2" v-bind="attrs" v-on="on">
                            New User
                        </v-btn>
                    </template>
                    <v-card>
                        <v-card-title>
                            <span class="text-h5">{{ formTitle }}</span>
                        </v-card-title>

                        <v-card-text>
                            <v-container>
                                <v-row>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-text-field v-model="editedItem.Name" label="Name"></v-text-field>
                                    </v-col>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-text-field v-model="editedItem.calories" label="ID"></v-text-field>
                                    </v-col>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-text-field v-model="editedItem.Department" label="Department"></v-text-field>
                                    </v-col>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-text-field v-model="editedItem.Company" label="Company"></v-text-field>
                                    </v-col>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-text-field v-model="editedItem.Email" label="Email"></v-text-field>
                                    </v-col>
                                </v-row>
                            </v-container>
                        </v-card-text>

                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn color="red" text @click="close">
                                Cancel
                            </v-btn>
                            <v-btn color="blue darken-1" text @click="save">
                                Save
                            </v-btn>
                        </v-card-actions>
                    </v-card>
                </v-dialog>
                <v-dialog v-model="dialogDelete" max-width="500px">
                    <v-card>
                        <v-card-title class="text-h5">Are you sure you want to delete this item?</v-card-title>
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn color="red" text @click="closeDelete">Cancel</v-btn>
                            <v-btn color="blue darken-1" text @click="deleteItemConfirm">OK</v-btn>
                            <v-spacer></v-spacer>
                        </v-card-actions>
                    </v-card>
                </v-dialog>
            </v-toolbar>
        </template>
        <template v-slot:item.actions="{ item }">
            <v-icon small color="#2196F3" class="mr-2" @click="editItem(item)">
                mdi-pencil
            </v-icon>
            <v-icon small color="#F44336" @click="deleteItem(item)">
                mdi-delete
            </v-icon>
        </template>
        <template v-slot:no-data>
            <v-btn color="primary" @click="initialize">
                Reset
            </v-btn>
        </template>
    </v-data-table><br> -->

    <v-dialog v-model="edit" max-width="500px">
        <v-card>
            <v-card-title>
                <span class="text-h5">edititem</span>
            </v-card-title>

            <v-card-text>
                <v-container>
                    <v-row>
                        <v-col cols="12" sm="6" md="4">
                            <v-text-field v-model="editedItem.Name" label="Name"></v-text-field>
                        </v-col>
                        <v-col cols="12" sm="6" md="4">
                            <v-text-field v-model="editedItem.calories" label="ID"></v-text-field>
                        </v-col>
                        <v-col cols="12" sm="6" md="4">
                            <v-text-field v-model="editedItem.Department" label="Department"></v-text-field>
                        </v-col>
                        <v-col cols="12" sm="6" md="4">
                            <v-text-field v-model="editedItem.Company" label="Company"></v-text-field>
                        </v-col>
                        <v-col cols="12" sm="6" md="4">
                            <v-text-field v-model="editedItem.Email" label="Email"></v-text-field>
                        </v-col>
                    </v-row>
                </v-container>
            </v-card-text>

            <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="red" text @click="close">
                    Cancel
                </v-btn>
                <v-btn color="blue darken-1" text @click="save">
                    Save
                </v-btn>
            </v-card-actions>
        </v-card>
    </v-dialog>

    <v-dialog v-model="del" max-width="500px">
        <v-card>

            <v-card-title class="text-h5">Are you sure you want to delete this item?</v-card-title>
            <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="red" text @click="closeDelete">Cancel</v-btn>
                <v-btn color="blue darken-1" text @click="deleteItemConfirm">OK</v-btn>
                <v-spacer></v-spacer>
            </v-card-actions>
        </v-card>

    </v-dialog>
    <v-simple-table v-for="(o,indexss) in co" :key="indexss">
        <template v-slot:top>
            <v-toolbar flat color="#00796B">
                <v-toolbar-title class="white--text">Employee List</v-toolbar-title>
                <v-divider class="mx-4" inset vertical></v-divider>
                <v-text-field background-color="white" prepend-inner-icon="mdi-magnify" label="Search" single-line hide-details></v-text-field>
                <v-spacer></v-spacer>
                <v-dialog v-model="dialog" max-width="500px">
                    <template v-slot:activator="{ on, attrs }">
                        <v-btn color="#64B5F6" dark class="mb-2" v-bind="attrs" v-on="on">
                            New User
                        </v-btn>
                    </template>
                    <v-card>
                        <v-card-title>
                            <span class="text-h5">{{ formTitle }}</span>
                        </v-card-title>

                        <v-card-text>
                            <v-container>
                                <v-row>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-text-field v-model="editedItem.Name" label="Name"></v-text-field>
                                    </v-col>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-text-field v-model="editedItem.calories" label="ID"></v-text-field>
                                    </v-col>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-text-field v-model="editedItem.Department" label="Department"></v-text-field>
                                    </v-col>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-text-field v-model="editedItem.Company" label="Company"></v-text-field>
                                    </v-col>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-text-field v-model="editedItem.Email" label="Email"></v-text-field>
                                    </v-col>
                                </v-row>
                            </v-container>
                        </v-card-text>

                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn color="red" text @click="close">
                                Cancel
                            </v-btn>
                            <v-btn color="blue darken-1" text @click="save">
                                Save
                            </v-btn>
                        </v-card-actions>
                    </v-card>
                </v-dialog>
                <v-dialog v-model="dialogDelete" max-width="500px">
                    <v-card>
                        <v-card-title class="text-h5">Are you sure you want to delete this item?</v-card-title>
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn color="red" text @click="closeDelete">Cancel</v-btn>
                            <v-btn color="blue darken-1" text @click="deleteItemConfirm">OK</v-btn>
                            <v-spacer></v-spacer>
                        </v-card-actions>
                    </v-card>
                </v-dialog>
            </v-toolbar>
        </template>
        <thead>
            <tr>
                <th>
                    ID
                </th>
                <th>
                    Name&Lastname
                </th>
                <th>
                    Department
                </th>
                <th>
                    Company
                </th>
                <th>
                    Email
                </th>
                <th>
                    Edit/Delete
                </th>
            </tr>
        </thead>
        <tbody v-for="(n,index) in info" :key="index">
            <tr v-for="(m,indexs) in de" :key="indexs">
                <td>
                    {{ n.id}}
                </td>
                <td>
                    {{n.surename}}
                </td>
                <td>
                    {{ m.namedepartment}}
                </td>
                <td>
                    {{o.namecompany}}
                </td>
                <td>
                    {{ o.email}}
                </td>
                <td>
                    <v-icon small color="#2196F3" class="mr-2" @click="editItem()">
                        mdi-pencil
                    </v-icon>
                    <v-icon small color="#F44336" @click="deleteItem()">
                        mdi-delete
                    </v-icon>
                </td>
            </tr>
        </tbody>
    </v-simple-table>
    <div class="logout">
        <center>
            <v-btn color="error" dark large @click="logout">
                Logout
            </v-btn>
        </center>

    </div>
</div>
</template>

<script>
import Axios from "axios";
// const URL = "http://localhost:8081";
export default {
    data: () => ({
        info: [],
        de:[],
        co:[],
        search: '',
        dialog: false,
        edit: false,
        del:false,
        dialogDelete: false,
        headers: [{
                text: 'ID',
                value: 'ID'
            },
            {
                text: 'Name & Lastname',
                align: 'start',
                sortable: false,
                value: 'Name',
            },
            {
                text: 'Department',
                value: 'Department'
            },
            {
                text: 'Company',
                value: 'Company'
            },
            {
                text: 'Email',
                value: 'Email'
            },
            {
                text: 'Edit/Delete',
                value: 'actions',
                sortable: false
            },
        ],
        desserts: [],
        editedIndex: -1,
        editedItem: {
            Name: '',
            ID: 0,
            Department: '',
            Company: '',
            Email: '',
        },
        defaultItem: {
            Name: '',
            ID: 0,
            Department: '',
            Company: '',
            Email: '',
        },
    }),

    computed: {
        formTitle() {
            return this.editedIndex === -1 ? 'New User' : 'Edit'
        },
    },

    watch: {
        dialog(val) {
            val || this.close()
        },
        dialogDelete(val) {
            val || this.closeDelete()
        },
    },

    created() {
        // this.initialize(),
        // this.getname()
        Axios.get('/api/getAllEmployees').then((res) => {
            this.info = res.data
            console.log(this.info);
        }),
        Axios.get('/api/getAllDepartments').then((res) => {
            this.de = res.data
            console.log(this.de);
        }),
        Axios.get('/api/getAllCompanys').then((res) => {
            this.co = res.data
            console.log(this.co);
        })
    },

    methods: {
        getname() {
            Axios.get('/api/getAllEmployees').then((res) => {
                this.info = res.data
                console.log(this.info);
            })
            // this.$Axios
            //     .get(URL+"/api/getAllEmployees", 

            // )
            // .then((data) => {
            //           this.desserts=data.data.response

            //         })
            //         .catch((error) => {
            //             alert(error);
            //         });

        },

        editItem() {
            // alert("editssssss");
            this.edit = true,
            Axios.put('/api/getAllEmployees').then((res) => {
                this.info = res.data
                console.log(this.info);
            })
          
        },

        deleteItem() {
            // alert("editssssss");
            this.del = true,
            Axios.delete('/api/deleteEmployeeById/'+id).then((res) => {
                this.info = res.data
                console.log(this.info);
            })
        },

        deleteItemConfirm() {

            this.closeDelete()
        },

        close() {
            this.edit = false

        },

        closeDelete() {
            this.del = false
        },

        save() {

            this.close()
        },
        logout() {

            alert("Logout Complete");
            this.$router.push({
                path: "/",
            });
        },

    },
}
</script>
