<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />

		<!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
		Remove this if you use the .htaccess -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

		<title>Randomization</title>
		<meta name="description" content="This is a page template for reference" />
		<meta name="author" content="Team Samsung SCTS" />
		
		<!-- CSS Framework - Bootstrap, stroll.css -->
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/jquery.gritter.css"/>
		<link rel="stylesheet" href="css/chosen.css" />
		<!-- <link rel="stylesheet" href="css/datatable.css" /> -->
		
		<!-- customize css file -->
		<link rel="stylesheet" href="css/template.css" />
		<link rel="stylesheet" href="css/random.css" />
	</head>

	<body>
		
		<!-- Header of the HTML Page, including Navigation Bar -->
		<header class="nav-space fixed">
		    <div class="nav-wrapper"></div> <!--Wrapper wrap the navbar, specify the background and opacity -->
			
			<div class="columns row-fluid">
					<div class="topbar left" id="topbar-left">
						<img class="logo-icon" src="img/nav_bar/blue-samsung-logo.png" />
					</div>
					<div class="topbar left">
						<span class="nav-title">Randomization</span>
					</div>
					
					<div class="topbar right" id="topbar-right">
				  			<!--display username-->
		              		<ul class="nav">
			                    <li id="fat-menu" class="dropdown">
			                      <a href="#" id="drop1" role="button" class="dropdown-toggle" data-toggle="dropdown">
				                      <span class="ca-icon">U</span> Barack Obama | Logon: 3:20 PM<b class="caret"></b>
				                       
								  </a>
								  
			                      <ul class="dropdown-menu" role="menu" aria-labelledby="drop1">
			                        <li role="presentation"><a role="menuitem" class="nav-item" tabindex="-1" href="#">Action</a></li>
			                        <li role="presentation"><a role="menuitem" class="nav-item" tabindex="-1" href="#">Another action</a></li>
			                      </ul>
			                    </li>
		                  	</ul>

		                  	<!-- dislpay message icon -->
		                  	<ul class="nav" id="nav-msg">
			                    <li class="dropdown">
			                      <a href="#" id="add-regular" role="button" class="dropdown-toggle nav-tooltip" data-toggle="dropdown"
			                     		data-toggle="tooltip" data-placement="bottom" title="Mssages">
										<span class="ca-icon">@</span><sup><span class="hidden-phone">9</span></sup>
								   </a>
			                    </li>
			                    
		                  	</ul>
		                  	<!-- display logout icon -->
		                  	<ul class="nav">
		                  		 <li class="dropdown">
			                     	<a href="#" role="button" class="dropdown-toggle nav-tooltip logout-icon" data-toggle="dropdown"
			                     		data-toggle="tooltip" data-placement="bottom" title="Logout">
										<img src="img/logout.png" />
								    </a>
			                     </li>
		                  	</ul>
                  	</div>
			</div>
		</header>
		
		<!-- Start to Edit here, replace the div with other content -->
		<div class="mainbody">
			<div class="container-fluid sortable">
				<div class="row-fluid">
					<div class="span12 boxes">
							
						<div class="box-title">
							<h2 class="box-title-text">
								<i class="icon-info-sign"></i>
								<span class="break"></span>
								Defined Randomization Parameters
							</h2>

							<div class="box-title-btn">
								<a href="#" class="btn-minimize nav-tooltip" data-toggle="tooltip" data-placement="bottom" title="Show / Hide"><i class="icon-chevron-up"></i></a>
							</div>
						</div>
									
						<div class="box-content" id="random-area">
							<form class="form-horizontal">
									<div class="control-group">
										<label class="control-label" for="randomType">Randomization Type</label>
										<label class="control-label" for="randomType">${form.typeDesc}</label>
									</div>
									<div class="control-group">
										<label class="control-label" for="inputGrp">Number of Group</label>
										<label class="control-label" for="inputGrp">${form.groupSize}</label>
									</div>
									<div class="control-group">
										<label class="control-label" for="blockSize">Block Size</label>
										<label class="control-label" for="blockSize">${form.blockSize}</label>
									</div>
									<div class="control-group">
										<label class="control-label" for="statIntegrity">Is Imbalance Corrected?</label>
										<label class="control-label" for="statIntegrity">${form.imbalanceDesc}</label>
									</div>
									<div class="control-group">
										<label class="control-label">Strata Count</label>
										<label class="control-label">6</label>
									</div>
									<div class="control-group">
										<label class="control-label">Age (Young, Middle, Old)</label>
										<label class="control-label">Gender (Male, Female)</label>
									</div>
							</form>
							
						</div> <!-- end of .box-content -->
					</div>  <!-- end ofx-->
								
				</div> <!-- .row-fluid -->
			</div>

			<div class="container-fluid sortable">
				<div class="row-fluid">
					<div class="span12 boxes">
							
						<div class="box-title">
							<h2 class="box-title-text">
								<i class="icon-info-sign"></i>
								<span class="break"></span>
								Enter Subject Information
							</h2>

							<div class="box-title-btn">
								<a href="#" class="btn-minimize nav-tooltip" data-toggle="tooltip" data-placement="bottom" title="Show / Hide"><i class="icon-chevron-up"></i></a>
							</div>
						</div>
									
						<div class="box-content" id="random-area">
							<form class="form-horizontal">
								
									<div class="control-group">
										<label class="control-label" for="subjectId">Subject Id</label>
										<div class="controls">
											<input type="text" id="subjectId"  name="subjectId"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">Strata Id</label>
										<div class="controls">
											<input type="text" id="strataId"  name="strataId"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">Age</label>
										<div class="controls">
											<input type="text" id="age"  name="age"/>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">Gender</label>
										<div class="controls">
											<input type="text" id="gender"  name="gender"/>
										</div>
									</div>
									<div class="control-group">
										<div class="controls">
											<button type="submit" class="btn" name="enrollBtn">Enroll this subject</button>
										</div>
									</div>
								
							</form>
							
						</div> <!-- end of .box-content -->
					</div>  <!-- end ofx-->
								
				</div> <!-- .row-fluid -->
			</div>

			<div class="container-fluid sortable">
				<div class="row-fluid">
					<div class="span12 boxes">
							
						<div class="box-title">
							<h2 class="box-title-text">
								<i class="icon-info-sign"></i>
								<span class="break"></span>
								List of enrolled subjects
							</h2>

							<div class="box-title-btn">
								<a href="#" class="btn-minimize nav-tooltip" data-toggle="tooltip" data-placement="bottom" title="Show / Hide"><i class="icon-chevron-up"></i></a>
							</div>
						</div>
									
						<div class="box-content" id="random-area">
							<table class="table table-hover">
								<tr>
									<th>Subject id</th>
									<th>Age</th>
									<th>Gender</th>
									<th>Group</th>
								</tr>
								
								<c:forEach var="subject" items="${subjectList}">
									<tr>
										<td>${ subject.id }</td>
										<td>${ subject.age }</td>
										<td>${ subject.gender }</td>
										<td>${ subject.group }</td>
									</tr>
								</c:forEach>
								
							</table>
							
						</div> <!-- end of .box-content -->
					</div>  <!-- end ofx-->
								
				</div> <!-- .row-fluid -->
			</div>
			
		</div>
	 	
	 	
    	<!-- footer of the page -->
    	<footer>
    		
    	</footer>
    	
    	<!-- javascripts -->
    	<script src="http://code.jquery.com/jquery-1.9.0.js"></script>
    	<script src="js/jquery.min.js"></script>
    	<script src="js/bootstrap.js"></script>
    	<script src="js/bootstrap-dropdown.js"></script>
    	<script src="js/bootstrap-tooltip.js"></script>
    	<script src="js/bootstrap-popover.js"></script>
    	<script src="js/jquery.gritter.min.js"></script>
    	<script src="js/chosen.jquery.min.js"></script>
    	<script src="js/random.js"></script>
    	<script src="js/template.js"></script>
    	
    	<script src="js/jquery-ui.js"></script>
    	
	</body>
</html>