package com.eCommerce.Gateway.filters;

public class PreFilter extends ZuulFilter{
	
	public boolean shouldFilter() {
		return false;
	}
	public Object run() throws ZuulException{
		return null;
	}
	@Override
	public String filterType() {
		return null;
	}
	@Override
	public int filterOrder() {
		return 0;
	}
	
}
