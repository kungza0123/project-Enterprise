<template>
<v-form>
    <v-container>
        <center>
            <h2></h2>
            <img src="../picture/logo.png" alt="logo" width="400px" height="275px" />
            <br />
        </center>
        <center>
            <v-col md="3">
                <v-text-field class="inputtext" label="Username" placeholder="Username" outlined v-model="form.username">
                </v-text-field>
            </v-col>

            <v-col md="3">
                <v-text-field class="inputtext" label="Password" placeholder="Password" outlined v-model="form.password" type="password">
                </v-text-field>
            </v-col>

            <div class="col-lg-12">
                <v-btn color="success" class="mr-4" v-on:click="Ok()"> login </v-btn>

                <!-- <v-btn color="error" class="col-lg-1.5" @click="Report()" to="/report">
                      Report
                  </v-btn> -->
            </div>
        </center>
    </v-container>
</v-form>
</template>

  
  
<script>
import Axios from "axios";
// const URL = "http://selab.mfu.ac.th:7402";
export default {

    data() {
        return {
            form: {
                username: "",
                password: "",
            },
        };
    },

    methods: {
        Ok() {
            // if (this.form.username != "" && this.form.password != "") {
            //   Axios.get("/api/getAllUsers", {
            //             params: {
            //                 user: this.form.username,
            //                 pass: this.form.password,
            //             },
            //         })
            //         .then((data) => {
            //             if (data.data.response.length == 0) {
            //                 alert("Username or password wrong ")
            //             } else {

            //                 var user = JSON.stringify(data.data.response);
            //                 console.log(user)
            //                 window.sessionStorage.setItem("user", user);
            //                 this.$router.push({
            //                     path: "/home",
            //                 });
            //             }
            //         })
            //         .catch((error) => {
            //             alert(error);
            //         });
            // } else {
            //     alert("Please fill out the information correctly.");
            // }
            Axios.get("/api/getAllUsers").then((res) => {
                var user = res.data
                console.log("user", user);
                var login = user.find((data) => data.username == this.form.username && data.password == this.form.password)
                console.log(login)
                if (login == undefined) {
                    alert("Incorrect username or password.");
                } else {
                    alert("Login Complete");
                    this.$router.push({
                        path: "/home",
                    });
                }

            })

        },

        Report() {},
    },
};
</script>
  
  
<style>
#hh {
    text-align: center;
}

div .ok {
    padding-top: 1px;
    padding-right: 510px;
    padding-left: 10px;
}
</style>
