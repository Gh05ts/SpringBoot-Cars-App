package com.example.demo.resource;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.inject.Singleton;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;
//import org.glassfish.jersey.server.mvc.Viewable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.CarsDao;
import com.example.demo.model.Cars;

//@Component
//@Singleton
@Path("/")
public class CarsResource {
	
		@Autowired
		private CarsDao dao;

//		inside index(@Context final ServletContext context
		@GET
		@Produces(MediaType.TEXT_HTML)
		@Path("/")
		public Viewable index() {
			return new Viewable("/index");
		}

		@GET
		@Produces(MediaType.TEXT_HTML)
		@Path("/brandForm")
		public Viewable brandForm() {
			Optional<List<String>> cars = dao.findDistinctBrands();
			Map<String, List<String>> model = new HashMap<>();
			cars.ifPresent(list -> {
				model.put("list", list);
			});
			return new Viewable("/brand", model);
		}

		@GET
		@Produces(MediaType.TEXT_HTML)
		@Path("/priceForm")
		public Viewable priceForm() {
			return new Viewable("/price");
		}
		
		@POST
		@Path("/showBrand")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_HTML)
		public Response brandView(
				@DefaultValue("null") @FormParam("formBrand") String brand, 
				@DefaultValue("null") @FormParam("low") String rb) throws URISyntaxException 
		{
			Boolean isBrand = false;
			String value;
			if(brand.equals("null")) {
				value = rb;
			} else {
				value = brand;
				isBrand = true;
			}
			
			String url = "/list?"+
			"isBrand="+isBrand.toString()+"&"+
			"value="+value;
			return Response.seeOther(new URI(url.replaceAll(" ", "%20"))).build();

//			Map<String, Object> model = new HashMap<>();
//			return Response.ok(new Viewable("/selection", model)).build();
//			@Context HttpServletRequest request, @Context HttpServletResponse response
		}
		
		@GET
		@Path("/list")
		@Produces(MediaType.TEXT_HTML)
		public Viewable listView(
				@DefaultValue("false") @QueryParam("isBrand") String isBrand,
				@DefaultValue("false") @QueryParam("value") String value) {
			Optional<List<Cars>> car;
			value = value.replaceAll("%20", " ");
			Map<String, Object> model = new HashMap<>();
			if(isBrand.equals("true")) {
				car = dao.findByBrand(value);
				model.put("brand", "true");
			} else if(value.startsWith("low")) {
				Long param = helper(value);
				car = dao.findByPriceLessThanEqual(param);
				model.put("brand", "false");
			} else {
				Long param = helper(value);
				car = dao.findByPriceGreaterThanEqual(param);
				model.put("brand", "false");
			}
			car.ifPresent(list -> {
				model.put("cars", list);
			});
			return new Viewable("/selection", model);
		}
		
		// Takes the input, gets number from end and multiplies with 1 Lakh
		public Long helper(String input) {
			StringBuffer sb = new StringBuffer();
			int len = input.length() - 1;
			for(; len >= 0 && Character.isDigit(input.charAt(len)); len--) {
				sb.append(input.charAt(len));
			}
			sb.reverse();			
			return Long.parseLong(sb.toString())*100000;
		}

		@POST
		@Path("/interim")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_HTML)
		public Response inter(
				@DefaultValue("null") @FormParam("id") String id) throws URISyntaxException  {
			String url = "/final?id="+id;
			return Response.seeOther(new URI(url)).build();
		}
		
		@GET
		@Path("/final")
		@Produces(MediaType.TEXT_HTML)
		public Viewable result(@DefaultValue("null") @QueryParam("id") String id) {
			Optional<Cars> car = dao.findById(Long.parseLong(id));
			StringBuilder name = new StringBuilder();
			car.ifPresent(obj -> {
				name.append(obj.getBrand() + " " +obj.getModel());
			});
			return new Viewable("/result", name.toString());
		}
}
