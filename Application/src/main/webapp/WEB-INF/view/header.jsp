<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/welcome" class="navbar-brand">EVMEMO</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<c:choose>
						<c:when test="${logged=='IN' }">
							<li><a href="/logout">Logout</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="/login">Login</a></li>
							<li><a href="/register">New Registration</a></li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${mode=='ALL_USERS' }">
							<li><a href="/show-users">All Users</a></li>
						</c:when>
					</c:choose>
				</ul>
			</div>
		</div>
	</div>