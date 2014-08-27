<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<%@ page import="com.v2crm.domain.*" %>
<%

Oppurtunity oppurtunity = (Oppurtunity) request.getAttribute("oppurtunity");
if(oppurtunity == null){
	oppurtunity = new Oppurtunity();
}

session.setAttribute("oppurtunity", oppurtunity);
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
                        
                        <li>
                            <a href="DisplayCampaigns">
                                <i class="fa fa-edit"></i> <span>Campaigns</span>
                                <small class="badge pull-right bg-green">new</small>
                            </a>
                            
                        </li>
                         <li>
                            <a href="DisplayOppurtunities">
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
                        Oppurtunity Form
                        <small>Control panel</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li class="active">Oppurtunity</li>
                    </ol>
                </section>
				
 <!--<div class="bs-example"> -->
 

  <div class="container">
    <form id="orgForm" action="SaveOppurtunity">
        <div class="row">
			<div class="col-xs-2">
                <label for="oppurtunityName" class="control-label" style="font-weight: normal;" style="font-weight: normal;">Oppurtunity Name</label>
				<input type="text" class="form-control" id="oppurtunityName" name="oppurtunityName" placeholder="Oppurtunity Name" value="<%= oppurtunity.getOppurtunityName() %>">
            </div>
           
			<div class="col-xs-2">
                <label for="amount" class="control-label" style="font-weight: normal;" style="font-weight: normal;">~Amount</label>
				<input type="text" class="form-control" id="amount" name="amount" placeholder="amount" value="<%= oppurtunity.getAmount() %>">
            </div>
           
           <div class="col-xs-2">
                <label for="probability" class="control-label" style="font-weight: normal;">Probability%</label>
				<input type="text" class="form-control" id="probability" name="probability" placeholder="Probability" value="<%= oppurtunity.getProbability() %>">
            </div>
           
        </div>
        
        <div class="row">
			 <div class="col-xs-2">
                <label for="expectedClosedDate" class="control-label" style="font-weight: normal;">Expected Closure Date</label>
				<input type="text" class="form-control" placeholder="ExpectedClosedDate" id = "expectedClosedDate" name="expectedClosedDate" value="<%= oppurtunity.getStartDt() %>">
            </div>
           
		<div class="col-xs-2">
                <label for="salesStage" class="control-label" style="font-weight: normal;">Select Sales Stage</label>
				<select name='salesStage' class="form-control">  <option value="none">Select</option>  
				<% 
				SalesStage sStages[] = SalesStage.values(); 
				for(int i=0;i<sStages.length;i++){
				%>
				<option value="<%=sStages[i].getMsg().trim()%>" <% if(oppurtunity.getSalesStage().getMsg().trim().equals(sStages[i].getMsg().trim())) {  %>selected<% } %>><%=sStages[i].getMsg()%>
				</option> <%
 				}
     			%>
				</select>
            </div>
           
            <div class="col-xs-2">
                <label for="leadSource" class="control-label" style="font-weight: normal;">Select Sales Stage</label>
				<select name='leadSource' class="form-control">  <option value="none">Select</option>  
				<% 
				LeadSource sources[] = LeadSource.values(); 
				for(int i=0;i<sStages.length;i++){
				%>
				<option value="<%=sources[i].getMsg().trim()%>" <% if(oppurtunity.getLeadSource().getMsg().trim().equals(sources[i].getMsg().trim())) {  %>selected<% } %>><%=sources[i].getMsg()%>
				</option> <%
 				}
     			%>
				</select>
            </div>
           
        </div>
        
        <div class="row">
			<div class="col-xs-2">
                <label for="oppurtunityType" class="control-label" style="font-weight: normal;">Select Sales Stage</label>
				<select name='oppurtunityType' class="form-control">  <option value="none">Select</option>  
				<% 
				OppurtunityType types[] = OppurtunityType.values(); 
				for(int i=0;i<types.length;i++){
				%>
				<option value="<%=types[i].getMsg().trim()%>" <% if(oppurtunity.getOppurtunityType().getMsg().trim().equals(types[i].getMsg().trim())) {  %>selected<% } %>><%=types[i].getMsg()%>
				</option> <%
 				}
     			%>
				</select>
            </div>
           
			<div class="col-xs-2">
                <label for="oppurtunityStrategy" class="control-label" style="font-weight: normal;">Select Oppurtunity Strategy</label>
				<select name='oppurtunityStrategy' class="form-control">  <option value="none">Select</option>  
				<% 
				OppurtunityStrategy strategies[] = OppurtunityStrategy.values(); 
				for(int i=0;i<strategies.length;i++){
				%>
				<option value="<%=strategies[i].getMsg().trim()%>" <% if(oppurtunity.getOppurtunityStrategy().getMsg().trim().equals(strategies[i].getMsg().trim())) {  %>selected<% } %>><%=strategies[i].getMsg()%>
				</option> <%
 				}
     			%>
				</select>
            </div>
           
			<div class="col-xs-2">
                <label for="probability" class="control-label" style="font-weight: normal;">~Probability</label>
				<input type="text" class="form-control" placeholder="probability" id = "probability" name="probability" value="<%= oppurtunity.getProbability() %>">
            </div>
           
        </div>
		
        <div class="row">
			<div class="col-xs-2">
                <label for="primaryEmail" class="control-label" style="font-weight: normal;">Primary Email</label>
				<input type="text" class="form-control" placeholder="primaryEmail" id = "primaryEmail" name="primaryEmail" value="<%= oppurtunity.getPrimaryEmail() %>">
            </div>
           
			<div class="col-xs-2">
                <label for="campaignResponseType" class="control-label" style="font-weight: normal;">Select Campaign Response Type</label>
				<select name='campaignResponseType' class="form-control">  <option value="none">Select</option>  
				<% 
				CampaignResponseType cRTypes[] = CampaignResponseType.values(); 
				for(int i=0;i<cRTypes.length;i++){
				%>
				<option value="<%=cRTypes[i].getMsg().trim()%>" <% if(campaign.getCampaignResponseType().getMsg().trim().equals(cRTypes[i].getMsg().trim())) {  %>selected<% } %>><%=cRTypes[i].getMsg()%>
				</option> <%
 				}
     			%>
				</select>
            </div>
			
			<div class="col-xs-2">
                <label for="campaign" class="control-label" style="font-weight: normal;">Campaign</label>
				<input type="text" class="form-control" id="campaign" name="campaign" placeholder="Search campaign" value="later">
            </div>
          
	    </div>
	    
	    <div class="row">
			 <div class="col-xs-4">
                <label for="description" class="control-label" style="font-weight: normal;">Description</label>
				<input type="text" class="form-control" id="description" name="description" placeholder="description" value="<%= oppurtunity.getDescription() %>">
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
                
             $( "#expectedClosedDate" ).datepicker();
             
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