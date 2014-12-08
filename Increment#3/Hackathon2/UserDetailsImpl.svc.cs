using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using System.Data.SqlClient;
using System.Configuration;
using System.Net;

namespace Hackathon2
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Service1" in code, svc and config file together.
    public class UserDetailsImpl : IUserDetails
    {
        SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings["dbString"].ConnectionString);

        public UserValidity ValidateUser(string user_name, string pwd)
        {
            
            conn.Open();

            SqlCommand cmd = new SqlCommand("Select * From USER_DATA where user_name='"+user_name+"'", conn);
            SqlDataReader reader = cmd.ExecuteReader();
            bool valid = false;
            if (reader.HasRows)
            {
                reader.Read();
                string storedPwd = reader["pwd"].ToString();
                if (storedPwd.Equals(pwd))
                    valid = true;
            }
            reader.Close();
            //close the connection
            conn.Close();
            return new UserValidity { success = valid };
            //return "usr_name: " + user_name + "  : " + fname + " : " + lname + " : " + phoneno;
        }


        public void Register(UserRegistration userDetails)
        {
            if (WebOperationContext.Current.IncomingRequest.Method == "OPTIONS")
            {
                return;
            }

            if (WebOperationContext.Current.IncomingRequest.Method != "POST")
            {
                throw new WebFaultException(HttpStatusCode.MethodNotAllowed);
            }

            conn.Open();

            SqlCommand cmd = new SqlCommand("Insert into USER_DATA " +
                "(FNAME,LNAME,PHONENO,ADDRESS,CITY,STATE,USER_NAME,PWD) " +
                "VALUES ('" + userDetails.fname + "','" + userDetails.lname + "','" + userDetails.phonenum + "','" + userDetails.address +
                "','" + userDetails.city + "','" + userDetails.state + "','" + userDetails.user_name + "','" + userDetails.pwd + "')", conn);
            try
            {
                cmd.ExecuteNonQuery();
                cmd.Dispose();
            }
            catch (System.Data.SqlClient.SqlException e)
            {
                throw new WebFaultException(HttpStatusCode.InternalServerError);
            }
            
            conn.Close();

       }

    }
}
