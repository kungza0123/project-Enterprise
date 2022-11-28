<template>
<div>
    <v-col></v-col>
    <v-data-table :headers="headers" :items="desserts" :search="search" sort-by="calories" class="elevation-1">
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
    </v-data-table><br>
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
export default {
    data: () => ({
        search: '',
        dialog: false,
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
        this.initialize()
        
    },

    methods: {
        initialize() {
            this.desserts = [{
                    Name: 'Frozen Yogurt',
                    ID: 159,
                    Department: 6.0,
                    Company: 24,
                    Email: 4.0,
                },
                {
                    Name: 'Ice cream sandwich',
                    ID: 237,
                    Department: 9.0,
                    Company: 37,
                    Email: 4.3,
                },
                {
                    Name: 'Eclair',
                    ID: 262,
                    Department: 16.0,
                    Company: 23,
                    Email: 6.0,
                },
                {
                    Name: 'Cupcake',
                    ID: 305,
                    Department: 3.7,
                    Company: 67,
                    Email: 4.3,
                },
                {
                    Name: 'Gingerbread',
                    ID: 356,
                    Department: 16.0,
                    Company: 49,
                    Email: 3.9,
                },
                {
                    Name: 'Jelly bean',
                    ID: 375,
                    Department: 0.0,
                    Company: 94,
                    Email: 0.0,
                },
                {
                    Name: 'Lollipop',
                    ID: 392,
                    Department: 0.2,
                    Company: 98,
                    Email: 0,
                },
                {
                    Name: 'Honeycomb',
                    ID: 408,
                    Department: 3.2,
                    Company: 87,
                    Email: 6.5,
                },
                {
                    Name: 'Donut',
                    ID: 452,
                    Department: 25.0,
                    Company: 51,
                    Email: 4.9,
                },
                {
                    Name: 'KitKat',
                    ID: 518,
                    Department: 26.0,
                    Company: 65,
                    Email: 7,
                },
            ]
        },

        editItem(item) {
            this.editedIndex = this.desserts.indexOf(item)
            this.editedItem = Object.assign({}, item)
            this.dialog = true
        },

        deleteItem(item) {
            this.editedIndex = this.desserts.indexOf(item)
            this.editedItem = Object.assign({}, item)
            this.dialogDelete = true
        },

        deleteItemConfirm() {
            this.desserts.splice(this.editedIndex, 1)
            this.closeDelete()
        },

        close() {
            this.dialog = false
            this.$nextTick(() => {
                this.editedItem = Object.assign({}, this.defaultItem)
                this.editedIndex = -1
            })
        },

        closeDelete() {
            this.dialogDelete = false
            this.$nextTick(() => {
                this.editedItem = Object.assign({}, this.defaultItem)
                this.editedIndex = -1
            })
        },

        save() {
            if (this.editedIndex > -1) {
                Object.assign(this.desserts[this.editedIndex], this.editedItem)
            } else {
                this.desserts.push(this.editedItem)
            }
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
