<%@page import="java.io.BufferedReader"%><%@page import="java.io.InputStreamReader"%><%@page import="java.io.OutputStream"%><%@page import="java.io.InputStream"%><%@page import="java.net.URL"%><%@ page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%><%
	URL url = new URL("https://rss.joins.com/sonagi/joins_sonagi_world_list.xml");
	BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
	int b = 0;
	while((b = br.read()) != -1) {
		out.write(b);		
	}
%>