<template>
<div>
    <v-simple-table>
        <template v-slot:top>
            <v-toolbar flat color="#00796B">
                <v-toolbar-title class="white--text">Employee List</v-toolbar-title>
                <v-divider class="mx-4" inset vertical></v-divider>
                <v-text-field background-color="white" prepend-inner-icon="mdi-magnify" label="Search" single-line hide-details>

                </v-text-field>
                <v-spacer></v-spacer>

                <v-dialog v-model="newuser" max-width="500px">
                    <template v-slot:activator="{ on, attrs }">
                        <v-btn color="#1976D2" dark class="mb-2" v-bind="attrs" v-on="on">
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
                                        <v-text-field v-model="editedItem.Department" label="Department"></v-text-field>
                                    </v-col>
                                    <!-- <v-col cols="12" sm="6" md="4">
                                        <v-combobox v-model="editedItem.Department" v-for="(d,inx) in this.items" :key="inx" :items="items" label="Department"></v-combobox>
                                    </v-col> -->
                                    <!-- <v-col cols="12" sm="6" md="4">
                                        <v-text-field v-model="editedItem.Company" label="Commmpany"></v-text-field>
                                    </v-col> -->
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
        <!-- <tbody v-for="(n,index) in info" :key="index"> -->
        <tbody v-for="(m,indexs) in info" :key="indexs" :items="info">
            <tr>
                <td>
                    {{ m.id}}
                </td>
                <td>
                    {{m.surename}}
                </td>
                <td>
                    {{ m.department.namedepartment}}
                </td>
                <td>
                    {{m.department.company.namecompany}}
                </td>
                <td>
                    {{ m.email}}
                </td>
                <td>
                    <v-icon small color="#2196F3" class="mr-2" @click="editItem(m)">
                        mdi-pencil
                    </v-icon>
                    <v-icon small color="#F44336" @click="deleteItem(m)">
                        mdi-delete
                    </v-icon>
                </td>
            </tr>
            <v-dialog v-model="del" max-width="500px">
                <v-card>

                    <v-card-title class="text-h5">Are you sure you want to delete this item?</v-card-title>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn color="red" text @click="closeDelete">Cancel</v-btn>
                        <v-btn color="blue darken-1" text @click="deleteItemConfirm()">OK</v-btn>
                        <v-spacer></v-spacer>
                    </v-card-actions>
                </v-card>

            </v-dialog>
            <v-dialog v-model="edit" max-width="500px">
                <v-card>
                    <v-card-title>
                        <span class="text-h5">Edit item</span>
                    </v-card-title>

                    <v-card-text>
                        <v-container>
                            <v-row>
                                <v-col cols="12" sm="6" md="4">
                                    <v-text-field v-model="editedItem.Name" label="Name"></v-text-field>
                                </v-col>
                                <v-col cols="12" sm="6" md="4">
                                    <v-text-field v-model="editedItem.Department" label="Department"></v-text-field>
                                </v-col>
                                <!-- <v-col cols="12" sm="6" md="4">
                            <v-text-field v-model="editedItem.Company" label="Company"></v-text-field>
                        </v-col> -->
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
                        <v-btn color="blue darken-1" text @click="ok">
                            Save
                        </v-btn>
                    </v-card-actions>

                </v-card>
            </v-dialog>
        </tbody>
    </v-simple-table><br>
    <div class="logout">
        <center>
            <v-btn color="#D50000" dark large @click="logout">
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
        de: [],
        co: [],
        form: {
            id: ""
        },

        search: '',
        dialog: false,
        edit: false,
        del: false,
        newuser: false,
        dialogDelete: false,
        desserts: [],
        editedIndex: -1,
        editedItem: {
            Name: '',
            Department: '',
            Company: '',
            Email: '',
        },
        defaultItem: {
            Name: '',
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
        })

    },

    methods: {
        ok() {
            // alert("editssssss");

            Axios.post('/api/updateEmployeeById/' + this.form.id, {
                surename: this.editedItem.Name,

                department: {
                    id: this.editedItem.Department
                },
                email: this.editedItem.Email
            }).then((res) => {
                Axios.get('/api/getAllEmployees').then((res) => {
                    this.info = res.data
                })
                // this.reset(this.ok)
            })
            this.edit = false;
        },
        editItem(index) {
            this.edit = true;
            this.form = index;
        },
        deleteItem(index) {
            // alert("editssssss");
            this.del = true;
            this.form = index;

        },
        deleteItemConfirm() {
            // console.log(index.id)
            Axios.delete("/api/deleteEmployeeById/" + this.form.id).then((res) => {
                Axios.get('/api/getAllEmployees').then((res) => {
                    this.info = res.data
                    console.log("test", this.info);
                })
            })
            this.closeDelete()
        },

        close() {
            this.edit = false
            this.newuser = false

        },

        closeDelete() {
            this.del = false
        },
        reset(){
            this.editedItem.Name="";
            this.editedItem.Department="";
            this.editedItem.Email="";

        },
        save() {
            Axios.post("/api/addEmployee", {
                surename: this.editedItem.Name,
                department: {
                    id: this.editedItem.Department,
                },
                email: this.editedItem.Email
            }).then((res) => {
                Axios.get('/api/getAllEmployees').then((res) => {
                    this.info = res.data
                    console.log("test", this.info);
                })
            })
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
