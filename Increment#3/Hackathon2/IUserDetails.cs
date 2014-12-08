using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace Hackathon2
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IService1" in both code and config file together.
    [ServiceContract]
    public interface IUserDetails
    {
        [WebInvoke(Method = "GET", ResponseFormat = WebMessageFormat.Json, UriTemplate = "validate/{user_name}/{pwd}")]
        UserValidity ValidateUser(string user_name, string pwd);

        //For POST method
        [WebInvoke(Method = "*", RequestFormat = WebMessageFormat.Json, 
            ResponseFormat = WebMessageFormat.Json, BodyStyle = WebMessageBodyStyle.Bare, 
            UriTemplate = "register")]
        void Register(UserRegistration userDetails);

        // TODO: Add your service operations here
    }

    [DataContract]
    public class UserRegistration
    {
        [DataMember]
        public string fname {set;get;}

        [DataMember]
        public string lname { set; get; }

        [DataMember]
        public string phonenum { set; get; }

        [DataMember]
        public string address { set; get; }

        [DataMember]
        public string city { set; get; }

        [DataMember]
        public string state { set; get; }

        [DataMember]
        public string user_name { set; get; }

        [DataMember]
        public string pwd { set; get; }
    }

    [DataContract]
    public class UserValidity
    {
        [DataMember]
        public bool success { set; get; }
    }
}
