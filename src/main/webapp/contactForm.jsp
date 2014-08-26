<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<%@ page import="com.v2crm.domain.*" %>
<%

Contact contact = (Contact) request.getAttribute("contact");
if(contact == null){
	contact = new Contact();
}

session.setAttribute("contact", contact);
%>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Jatin Sutaria | Dashboard</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
		 <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
		<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
		
   
    <link rel="stylesheet" href="css/bootstrap.css"/>
    

    <!-- Include FontAwesome CSS if you want to use feedback icons provided by FontAwesome -->
    <link rel="stylesheet" href="css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" media="all" href="css/thvsjsp.css" th:href="@{css/thvsjsp.css}"/>

    <!-- BootstrapValidator CSS -->
    <link rel="stylesheet" href="css/bootstrapValidator.min.css"/>

    <!-- jQuery and Bootstrap JS -->
   
    <script type="text/javascript" src="js/bootstrap.min.js"></script>

    <!-- BootstrapValidator JS -->
    <script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
	 <!-- Ionicons -->
        <link href="css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- Morris chart -->
        <link href="css/morris/morris.css" rel="stylesheet" type="text/css" />
        <!-- jvectormap -->
        <link href="css/jvectormap/jquery-jvectormap-1.2.2.css" rel="stylesheet" type="text/css" />
        <!-- fullCalendar -->
        <link href="css/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css" />
        <!-- Daterange picker -->
        <link href="css/daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
        <!-- bootstrap wysihtml5 - text editor -->
        <link href="css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="css/AdminLTE.css" rel="stylesheet" type="text/css" />
		

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
        <style type="text/css">
		 .bs-example{
			margin: 20px;
		  }
		  
		  

		.bs-example  input[type="text"] {
		   height: 24px;
		   font-size: 15px;
		   line-height: 24px;
		}
		.bs-example  input::-webkit-input-placeholder {
	color: rgba(255,0,255,1); /* white color with alpha = 1 (alpha = opacity varies on a scale of 0 to 1 with decimal values in between) */
	text-transform: capitalize;
	font-size: 12px;
	font-style: italic;
	font-weight: lighter;
	letter-spacing: 0.1em;
	line-height: 18px;
	padding: 0px 10px;
	text-align: left;
	text-decoration: blink; /* blink property doesn't work in chrome right now */
}
input::-moz-placeholder {
	color: rgba(255,0,255,1);
	text-transform: capitalize;
	font-size: 12px;
	font-style: italic;
	font-weight: normal;
	letter-spacing: 0.1em;
	line-height: 25px;
	padding: 0px 10px;
	text-align: left;
	text-decoration: blink;
}
input:-moz-placeholder {   /* Older versions of Firefox */
	color: rgba(255,0,255,1);    /* alpha property doesn't properly work Firefox */
	text-transform: capitalize;
	font-size: 12px;
	font-style: italic;
	font-weight: normal;
	letter-spacing: 0.1em;
	line-height: 18px;
	padding: 0px 10px;
	text-align: left;
	text-decoration: blink;
}
input:-ms-input-placeholder { 
	color: rgba(255,0,255,1);
	text-transform: capitalize;
	font-size: 12px;
	font-style: italic;
	font-weight: normal;
	letter-spacing: 0.1em;
	line-height: 18px;
	padding: 0px 10px;
	text-align: left;
	text-decoration: blink;
}

		</style>
         
    </head>
    <body class="skin-blue">
        <!-- header logo: style can be found in header.less -->
        <header class="header">
            <a href="index.html" class="logo">
                <!-- Add the class icon to your logo image or logo icon to add the margining -->
                Jatin Sutaria
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top" role="navigation">
                <!-- Sidebar toggle button-->
                <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <div class="navbar-right">
                    <ul class="nav navbar-nav">
                        <!-- Messages: style can be found in dropdown.less-->
                        <li class="dropdown messages-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-envelope"></i>
                                <span class="label label-success">4</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="header">You have 4 messages</li>
                                <li>
                                    <!-- inner menu: contains the actual data -->
                                    <ul class="menu">
                                        <li><!-- start message -->
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="img/avatar3.png" class="img-circle" alt="User Image"/>
                                                </div>
                                                <h4>
                                                    Support Team
                                                    <small><i class="fa fa-clock-o"></i> 5 mins</small>
                                                </h4>
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li><!-- end message -->
                                        <li>
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="img/avatar2.png" class="img-circle" alt="user image"/>
                                                </div>
                                                <h4>
                                                    AdminLTE Design Team
                                                    <small><i class="fa fa-clock-o"></i> 2 hours</small>
                                                </h4>
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="img/avatar.png" class="img-circle" alt="user image"/>
                                                </div>
                                                <h4>
                                                    Developers
                                                    <small><i class="fa fa-clock-o"></i> Today</small>
                                                </h4>
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="img/avatar2.png" class="img-circle" alt="user image"/>
                                                </div>
                                                <h4>
                                                    Sales Department
                                                    <small><i class="fa fa-clock-o"></i> Yesterday</small>
                                                </h4>
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <div class="pull-left">
                                                    <img src="img/avatar.png" class="img-circle" alt="user image"/>
                                                </div>
                                                <h4>
                                                    Reviewers
                                                    <small><i class="fa fa-clock-o"></i> 2 days</small>
                                                </h4>
                                                <p>Why not buy a new awesome theme?</p>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="footer"><a href="#">See All Messages</a></li>
                            </ul>
                        </li>
                        <!-- Notifications: style can be found in dropdown.less -->
                        <li class="dropdown notifications-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-warning"></i>
                                <span class="label label-warning">10</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="header">You have 10 notifications</li>
                                <li>
                                    <!-- inner menu: contains the actual data -->
                                    <ul class="menu">
                                        <li>
                                            <a href="#">
                                                <i class="ion ion-ios7-people info"></i> 5 new members joined today
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <i class="fa fa-warning danger"></i> Very long description here that may not fit into the page and may cause design problems
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <i class="fa fa-users warning"></i> 5 new members joined
                                            </a>
                                        </li>

                                        <li>
                                            <a href="#">
                                                <i class="ion ion-ios7-cart success"></i> 25 sales made
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <i class="ion ion-ios7-person danger"></i> You changed your username
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="footer"><a href="#">View all</a></li>
                            </ul>
                        </li>
                        <!-- Tasks: style can be found in dropdown.less -->
                        <li class="dropdown tasks-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-tasks"></i>
                                <span class="label label-danger">9</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="header">You have 9 tasks</li>
                                <li>
                                    <!-- inner menu: contains the actual data -->
                                    <ul class="menu">
                                        <li><!-- Task item -->
                                            <a href="#">
                                                <h3>
                                                    Design some buttons
                                                    <small class="pull-right">20%</small>
                                                </h3>
                                                <div class="progress xs">
                                                    <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                        <span class="sr-only">20% Complete</span>
                                                    </div>
                                                </div>
                                            </a>
                                        </li><!-- end task item -->
                                        <li><!-- Task item -->
                                            <a href="#">
                                                <h3>
                                                    Create a nice theme
                                                    <small class="pull-right">40%</small>
                                                </h3>
                                                <div class="progress xs">
                                                    <div class="progress-bar progress-bar-green" style="width: 40%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                        <span class="sr-only">40% Complete</span>
                                                    </div>
                                                </div>
                                            </a>
                                        </li><!-- end task item -->
                                        <li><!-- Task item -->
                                            <a href="#">
                                                <h3>
                                                    Some task I need to do
                                                    <small class="pull-right">60%</small>
                                                </h3>
                                                <div class="progress xs">
                                                    <div class="progress-bar progress-bar-red" style="width: 60%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                        <span class="sr-only">60% Complete</span>
                                                    </div>
                                                </div>
                                            </a>
                                        </li><!-- end task item -->
                                        <li><!-- Task item -->
                                            <a href="#">
                                                <h3>
                                                    Make beautiful transitions
                                                    <small class="pull-right">80%</small>
                                                </h3>
                                                <div class="progress xs">
                                                    <div class="progress-bar progress-bar-yellow" style="width: 80%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                        <span class="sr-only">80% Complete</span>
                                                    </div>
                                                </div>
                                            </a>
                                        </li><!-- end task item -->
                                    </ul>
                                </li>
                                <li class="footer">
                                    <a href="#">View all tasks</a>
                                </li>
                            </ul>
                        </li>
                        <!-- User Account: style can be found in dropdown.less -->
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="glyphicon glyphicon-user"></i>
                                <span>Jane Doe <i class="caret"></i></span>
                            </a>
                            <ul class="dropdown-menu">
                                <!-- User image -->
                                <li class="user-header bg-light-blue">
                                    <img src="img/avatar3.png" class="img-circle" alt="User Image" />
                                    <p>
                                        Jane Doe - Web Developer
                                        <small>Member since Nov. 2012</small>
                                    </p>
                                </li>
                                <!-- Menu Body -->
                                <li class="user-body">
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Followers</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Sales</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Friends</a>
                                    </div>
                                </li>
                                <!-- Menu Footer-->
                                <li class="user-footer">
                                    <div class="pull-left">
                                        <a href="#" class="btn btn-default btn-flat">Profile</a>
                                    </div>
                                    <div class="pull-right">
                                        <a href="#" class="btn btn-default btn-flat">Sign out</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="img/avatar3.png" class="img-circle" alt="User Image" />
                        </div>
                        <div class="pull-left info">
                            <p>Hello, Jane</p>

                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>
                    <!-- search form -->
                    <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="Search..."/>
                            <span class="input-group-btn">
                                <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
                            </span>
                        </div>
                    </form>
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="active">
                            <a href="index.html">
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                            </a>
                        </li>
                        <li>
                            <a href="DisplayLeads">
                                <i class="fa fa-th"></i> <span>Leads</span> <small class="badge pull-right bg-green">new</small>
                            </a>
                        </li>
                        <li>
							<a href="DisplayOrganizations">
                                <i class="fa fa-th"></i> <span>Organizations</span> <small class="badge pull-right bg-green">new</small>
                            </a>
                            
                           
                        </li>
                        <li>
                            <a href="DisplayContacts">
                                <i class="fa fa-laptop"></i>
                                <span>Contacts</span>
                                <small class="badge pull-right bg-green">new</small>
                            </a>
                            
                        </li>
                        
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-edit"></i> <span>Oppurtunities</span>
                                <small class="badge pull-right bg-green">new</small>
                            </a>
                            
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-table"></i> <span>Documents</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            
                        </li>
                        <li>
                            <a href="pages/calendar.html">
                                <i class="fa fa-calendar"></i> <span>Calendar</span>
                               <small class="badge pull-right bg-green">new</small>
                            </a>
                        </li>
                        <li>
                            <a href="pages/mailbox.html">
                                <i class="fa fa-envelope"></i> <span>MailManager</span>
                               
                            </a>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-folder"></i> <span>Reports</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="pages/examples/invoice.html"><i class="fa fa-angle-double-right"></i> High Value Leads</a></li>
                                <li><a href="pages/examples/login.html"><i class="fa fa-angle-double-right"></i> High Value Oppurtunities</a></li>
                                <li><a href="pages/examples/register.html"><i class="fa fa-angle-double-right"></i> Hot Leads</a></li>
                                <li><a href="pages/examples/lockscreen.html"><i class="fa fa-angle-double-right"></i> Oppurtunities by Industry</a></li>
                                <li><a href="pages/examples/404.html"><i class="fa fa-angle-double-right"></i> Contacts By Organization</a></li>
                                <li><a href="pages/examples/500.html"><i class="fa fa-angle-double-right"></i> Contacts By Oppurtunities</a></li>
                                <li><a href="pages/examples/blank.html"><i class="fa fa-angle-double-right"></i> Closed Oppurtunities</a></li>
								<li><a href="pages/examples/blank.html"><i class="fa fa-angle-double-right"></i> Lost Oppurtunities</a></li>
                            </ul>
                        </li>
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">
           
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Contact Form
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li class="active">Lead</li>
                    </ol>
                </section>
				
 <!--<div class="bs-example"> -->
 

  <div class="container">
    <form id="contactForm" action="SaveContact">
        <div class="row">
			<div class="col-xs-2">
                <label for="contact.firstName" class="control-label" style="font-weight: normal;" style="font-weight: normal;">First Name</label>
				<input type="text" class="form-control" id="contact.firstName" name="firstName" placeholder="First Name" value="<%= contact.getFirstName() %>">
            </div>
           
			<div class="col-xs-2">
                <label for="contact.lastName" class="control-label" style="font-weight: normal;" style="font-weight: normal;">Last Name</label>
				<input type="text" class="form-control" id="contact.lastName" name="lastName" placeholder="Last Name" value="<%= contact.getLastName() %>">
            </div>
           <div class="col-xs-2">
                <label for="contact.company" class="control-label" style="font-weight: normal;">Company</label>
				<input type="text" class="form-control" placeholder="Company" id="company" name="company" value="<%= contact.getCompany() %>">
            </div>
           
        </div>
        
        <div class="row">
			<div class="col-xs-2">
                <label for="contact.primaryEmail" class="control-label" style="font-weight: normal;">Primary Email</label>
				<input type="email" class="form-control" id="contact.primaryEmail" name="primaryEmail" placeholder="Email" value="<%= contact.getPrimaryEmail() %>">
            </div>
           
			<div class="col-xs-2">
                <label for="contact.officePhone" class="control-label" style="font-weight: normal;">Office Phone</label>
				<input type="text" class="form-control" id="contact.officePhone" name="officePhone" placeholder="Office Phone" value="<%= contact.getOfficePhone() %>">
            </div>
           <div class="col-xs-2">
                <label for="contact.mobilePhone" class="control-label" style="font-weight: normal;">Mobile Phone</label>
				<input type="text" class="form-control" id="contact.mobilePhone" name="mobilePhone" placeholder="Mobile Phone" value="<%= contact.getMobilePhone() %>">
            </div>
           
        </div>
        
        <div class="row">
			<div class="col-xs-2">
                <label for="contact.homePhone" class="control-label" style="font-weight: normal;">Home Phone</label>
				<input type="text" class="form-control" id="contact.homePhone" name="homePhone" placeholder="Home Phone" value="<%= contact.getHomePhone() %>">
            </div>
           
			<div class="col-xs-2">
                <label for="contact.designation" class="control-label" style="font-weight: normal;">Designation</label>
				<input type="url" class="form-control" placeholder="Designation" name="designation" value="<%= contact.getDesignation() %>">
            </div>
           <div class="col-xs-2">
                <label for="contact.dateOfBirth" class="control-label" style="font-weight: normal;">Date Of Birth</label>
				<input type="text" class="form-control" placeholder="Date of Birth" id = "dateOfBirth" name="dateOfBirth" value="<%= contact.getDob() %>">
            </div>
           
        </div>
		
        <div class="row">
			<div class="col-xs-2">
                <label for="contact.messengerID" class="control-label" style="font-weight: normal;">Messenger ID</label>
				<input type="text" class="form-control" id="contact.messengerID" name="messengerID" placeholder="Preferred Messenger Id" value="<%= contact.getMessengerID() %>">
            </div>
           
			<div class="col-xs-2">
                <label for="contact.messengerType" class="control-label" style="font-weight: normal;">Select Messenger Type</label>
				<select name='messengerType' class="form-control">  <option value="none">Select</option>  
				<% 
				MessengerType mTypes[] = MessengerType.values(); 
				for(int i=0;i<mTypes.length;i++){
				%>
				<option value="<%=mTypes[i].getMsg().trim()%>" <% if(contact.getMessengerType().getMsg().trim().equals(mTypes[i].getMsg().trim())) {  %>selected<% } %>><%=mTypes[i].getMsg()%>
				</option> <%
 				}
     			%>
				</select>
            </div>
			
			<div class="col-xs-2">
                <label for="contact.department" class="control-label" style="font-weight: normal;">Department</label>
				<input type="text" class="form-control" id="contact.department" name="department" placeholder="Department" value="<%= contact.getDepartment() %>">
            </div>
          
	    </div>
        <div class="row">
			<div class="col-xs-2">
                <label for="contact.reference" class="control-label" style="font-weight: normal;">Reference</label><br>
				<input type="radio"  name="reference" value="true"  <% if(contact.isReference()){ %> checked<% } %> > Yes
				<input type="radio"  name="reference" value="false" <% if(!contact.isReference()){ %> checked<% } %> > No
            </div>
           
			<div class="col-xs-2">
                <label for="contact.reportsTo" class="control-label" style="font-weight: normal;">Reports To</label>
				<input type="text" class="form-control" id="contact.reportsTo" name="reportsTo" placeholder="Reports To" value="<%= contact.getReportsTo() %>">
            </div>
            
           <div class="col-xs-2">
                <label for="contact.fax" class="control-label" style="font-weight: normal;">Fax</label>
				<input type="text" class="form-control" id="contact.reportsTo" name="fax" placeholder="Fax" value="<%= contact.getFax() %>">
            </div>
           
        </div>
        
        <div class="row">
			<div class="col-xs-2">
                <label for="contact.doNotCall" class="control-label" style="font-weight: normal;">Do Not Call          </label><br>
				<input type="radio"  name="doNotCall" value="true"  <% if(contact.isDoNotCall()){ %> checked<% } %>> Yes
				<input type="radio"  name="doNotCall" value="false" <% if(!contact.isDoNotCall()) { %> checked<% } %>> No
            </div>
           
			<div class="col-xs-2">
                <label for="contact.contactSource" class="control-label" style="font-weight: normal;">Contact Type</label>
				<select name='contactSource' class="form-control">  <option value="none">Select</option>  
				<% 
				LeadSource sources[] = LeadSource.values(); 
				for(int i=0;i<sources.length;i++){
				%>
				<option value="<%=sources[i].getMsg().trim()%>" <% if(contact.getContactSource().getMsg().trim().equals(sources[i].getMsg().trim())) {  %>selected<% } %>><%=sources[i].getMsg()%>
				</option> <%
 				}
     			%>
				</select>
            </div>
            
           <div class="col-xs-2">
              
            </div>
           
        </div>
		
		<b><hr></b>
		<h4>
	<u><ul>Office Address<ul></u>
			
		</h4>
		
		<div class="row">
			<div class="col-xs-2">
                <label for="city" class="control-label" style="font-weight: normal;">City</label>
				<input type="text" class="form-control" id="contact.city" name="city" placeholder="City" value="<%= contact.getOfficeAddress().getCity() %>"	>
            </div>
           
			<div class="col-xs-2">
                <label for="street" class="control-label" style="font-weight: normal;">Street</label>
				<input type="text" class="form-control" placeholder="Street" name="street" value="<%= contact.getOfficeAddress().getStreet() %>">
            </div>
           <div class="col-xs-2">
                <label for="building" class="control-label" style="font-weight: normal;" style="font-weight: normal;">Building</label>
				<input type="text" class="form-control" placeholder="Building" name="building" value="<%= contact.getOfficeAddress().getBldg() %>">
            </div>
           
        </div>
		<br>
		<div class="row">
			<div class="col-xs-2">
                <label for="officeNumber" class="control-label" style="font-weight: normal;">Office Number</label>
				<input type="text" class="form-control" id="officeNumber" name="officeNumber" placeholder="Off or Res No" value="<%= contact.getOfficeAddress().getOfficeNumber() %>">
             </div>
           
			<div class="col-xs-2">
                <label for="zip" class="control-label" style="font-weight: normal;">Zip</label>
				<input type="text" class="form-control" placeholder="Zip or Pin" name="zip" value="<%= contact.getOfficeAddress().getPin() %>">
            </div>
           <div class="col-xs-2">
                <label for="state" class="control-label" style="font-weight: normal;">State</label>
				<select name='state'>  <option value="none">Select</option>  
				<% 
				State states[] = State.values(); 
				for(int i=0;i<states.length;i++){
				%>
				<option value="<%=states[i].getMsg().trim()%>" <% if(contact.getOfficeAddress().getState().getMsg().trim().equals(states[i].getMsg().trim())) {  %>selected<% } %>><%=states[i].getMsg()%>
				</option> <%
 				}
     			%>
				</select>
            </div>
           
        </div>
		<br>
		<div class="row">
			<div class="col-xs-2">
                <label for="country" class="control-label" style="font-weight: normal;">Country</label>
				<input type="text" class="form-control" id="country" placeholder="Country" name="country" value="<%= contact.getOfficeAddress().getCountry() %>">
            </div>
           
			<div class="col-xs-2">
              
            </div>
           <div class="col-xs-2">
              
            </div>
           
        </div>
		<br>
		
		
		<b><hr></b>
		<h4>
	<u><ul>Home Address<ul></u>
			
		</h4>
		
		<div class="row">
			<div class="col-xs-2">
                <label for="city_home" class="control-label" style="font-weight: normal;">City</label>
				<input type="text" class="form-control" id="contact.city" name="city_home" placeholder="City" value="<%= contact.getHomeAddress().getCity() %>"	>
            </div>
           
			<div class="col-xs-2">
                <label for="street" class="control-label" style="font-weight: normal;">Street</label>
				<input type="text" class="form-control" placeholder="Street" name="street_home" value="<%= contact.getHomeAddress().getStreet() %>">
            </div>
           <div class="col-xs-2">
                <label for="building" class="control-label" style="font-weight: normal;" style="font-weight: normal;">Building</label>
				<input type="text" class="form-control" placeholder="Building" name="building_home" value="<%= contact.getHomeAddress().getBldg() %>">
            </div>
           
        </div>
		<br>
		<div class="row">
			<div class="col-xs-2">
                <label for="officeNumber" class="control-label" style="font-weight: normal;">Office Number</label>
				<input type="text" class="form-control" id="officeNumber" name="officeNumber_home" placeholder="Off or Res No" value="<%= contact.getHomeAddress().getOfficeNumber() %>">
             </div>
           
			<div class="col-xs-2">
                <label for="zip" class="control-label" style="font-weight: normal;">Zip</label>
				<input type="text" class="form-control" placeholder="Zip or Pin" name="zip_home" value="<%= contact.getHomeAddress().getPin() %>">
            </div>
           <div class="col-xs-2">
                <label for="state" class="control-label" style="font-weight: normal;">State</label>
				<select name='state_home'>  <option value="none">Select</option>  
				<% 
				State states1[] = State.values(); 
				for(int i=0;i<states1.length;i++){
				%>
				<option value="<%=states1[i].getMsg().trim()%>" <% if(contact.getHomeAddress().getState().getMsg().trim().equals(states1[i].getMsg().trim())) {  %>selected<% } %>><%=states1[i].getMsg()%>
				</option> <%
 				}
     			%>
				</select>
            </div>
           
        </div>
		<br>
		<div class="row">
			<div class="col-xs-2">
                <label for="country" class="control-label" style="font-weight: normal;">Country</label>
				<input type="text" class="form-control" id="country" placeholder="Country" name="country_home" value="<%= contact.getHomeAddress().getCountry() %>">
            </div>
           
			<div class="col-xs-2">
              
            </div>
           <div class="col-xs-2">
              
            </div>
           
        </div>
        <br>
		
		<div class="row">
			<div class="col-xs-2">
                <button type="submit" class="btn btn-primary">Save</button>
            </div>
           
			<div class="col-xs-4">
              
            </div>
           <div class="col-xs-2">
              
            </div>
           
        </div>
    </form>
</div>


<script>
		$(document).ready(function() {
			$('#contactForm').bootstrapValidator({
				// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
				feedbackIcons: {
					valid: 'glyphicon glyphicon-ok',
					invalid: 'glyphicon glyphicon-remove',
					validating: 'glyphicon glyphicon-refresh'
				},
				fields: {
					firstName: {
						validators: {
							notEmpty: {
								message: 'The gender is required'
							},
							stringLength: {
								min: 6,
								max: 30,
								message: 'The username must be more than 6 and less than 30 characters long'
							}
						}
					},
					lastName: {
						validators: {
							notEmpty: {
								message: 'The gender is required'
							}
						}
					},
					company: {
						validators: {
							notEmpty: {
								message: 'The gender is required'
							}
						}
					},
					primaryEmail: {
						validators: {
							notEmpty: {
								message: 'The email address is required and cannot be empty'
							},
							emailAddress: {
								message: 'The email address is not a valid'
							}
						}
            },
				}
			});
		});
		</script>
               </aside><!-- /.right-side -->
			 
        </div><!-- ./wrapper -->

        <script type="text/javascript">
            // When the document is ready
            $(document).ready(function () {
                
             $( "#dateOfBirth" ).datepicker();
  
				
            
            });
			
			
        </script>
        
        <!-- jQuery UI 1.10.3 -->
       
        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <!-- Morris.js charts -->
        <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
        <script src="js/plugins/morris/morris.min.js" type="text/javascript"></script>
        <!-- Sparkline -->
        <script src="js/plugins/sparkline/jquery.sparkline.min.js" type="text/javascript"></script>
        <!-- jvectormap -->
        <script src="js/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js" type="text/javascript"></script>
        <script src="js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js" type="text/javascript"></script>
        <!-- fullCalendar -->
        <script src="js/plugins/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
        <!-- jQuery Knob Chart -->
        <script src="js/plugins/jqueryKnob/jquery.knob.js" type="text/javascript"></script>
        <!-- daterangepicker -->
        <script src="js/plugins/daterangepicker/daterangepicker.js" type="text/javascript"></script>
        <!-- Bootstrap WYSIHTML5 -->
        <script src="js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js" type="text/javascript"></script>
        <!-- iCheck -->
        <script src="js/plugins/iCheck/icheck.min.js" type="text/javascript"></script>

        <!-- AdminLTE App -->
        <script src="js/AdminLTE/app.js" type="text/javascript"></script>
        
        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
        <script src="js/AdminLTE/dashboard.js" type="text/javascript"></script>        
		

    </body>
</html>