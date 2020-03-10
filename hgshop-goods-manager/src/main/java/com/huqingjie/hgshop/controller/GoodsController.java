package com.huqingjie.hgshop.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.huqingjie.hgshop.pojo.Brand;
import com.huqingjie.hgshop.pojo.Sku;
import com.huqingjie.hgshop.pojo.Spec;
import com.huqingjie.hgshop.pojo.SpecOption;
import com.huqingjie.hgshop.pojo.Spu;
import com.huqingjie.hgshop.pojo.SpuVo;
import com.huqingjie.hgshop.service.BrandService;
import com.huqingjie.hgshop.service.GoodsService;
import com.huqingjie.hgshop.service.SkuService;
import com.huqingjie.hgshop.service.SpecService;
import com.huqingjie.hgshop.service.SpuService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("goods")
public class GoodsController {
	
	@Reference
	SpuService spuService;
	@Reference
	SkuService skuService;
	@Reference
	BrandService brandService;

	@Reference
	SpecService specService;
	
	
	@RequestMapping("list")
	public String list(HttpServletRequest request ,
			@RequestParam (defaultValue="1") int page,
			SpuVo spuVo) {
		PageInfo<Spu> listSpu = spuService.listSpu(page, spuVo);
		request.setAttribute("pageInfo", listSpu);
		return "goods/list";
	}
	
	@RequestMapping("toadd")
	public String toadd(HttpServletRequest request ) {
		List<Brand> allBrands = brandService.getAllBrands();
		request.setAttribute("brands", allBrands);
		return "goods/add";
	}
	
	
	@RequestMapping("add")
	@ResponseBody
	public String add(HttpServletRequest request,Spu spu,@RequestParam(value="file") MultipartFile file ) throws IllegalStateException, IOException {
		
		String filePath=processFile(file);
		spu.setSmallPic(filePath);
		
		int result = spuService.addSpu(spu);
		
		return result>0?"success":"failed";
		
	}
	
	@RequestMapping("down")
	public void downLoad(HttpServletResponse response, String filename) throws FileNotFoundException {
	    InputStream inStream = new FileInputStream("d:\\pic\\"+filename);
	    response.reset();
	    response.setContentType("bin");
	    response.addHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
	   
	    byte[] b = new byte[1024];
	    int len;
	    try {
	      while ((len = inStream.read(b)) > 0)
	        response.getOutputStream().write(b, 0, len);
	      inStream.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	
	}
	
	private String processFile(MultipartFile file) throws IllegalStateException, IOException {

		System.out.println("file.isEmpty() :" + file.isEmpty()  );
		System.out.println("file.name :" + file.getOriginalFilename());
		
		if(file.isEmpty()||"".equals(file.getOriginalFilename()) || file.getOriginalFilename().lastIndexOf('.')<0 ) {
			return "";
		}
			
		String originName = file.getOriginalFilename();
		String suffixName = originName.substring(originName.lastIndexOf('.'));
		SimpleDateFormat sdf=  new SimpleDateFormat("yyyyMMdd");
		String path = "d:/pic/" + sdf.format(new Date());
		File pathFile = new File(path);
		if(!pathFile.exists()) {
			pathFile.mkdir();
		}
		String destFileName = 		path + "/" +  UUID.randomUUID().toString() + suffixName;
		File distFile = new File( destFileName);
		file.transferTo(distFile);
		return destFileName.substring(7);
		
		
	}
	
	@RequestMapping("skulist")
	public String skulist(HttpServletRequest request ,
			@RequestParam (defaultValue="1") int page,Sku sku) {
		PageInfo<Sku> listSku = skuService.listSku(page, sku);
		request.setAttribute("pageInfo", listSku);
		return "sku/list";
	}
	
	@RequestMapping("skuDetail")
	public String skulist(HttpServletRequest request ,int id) {
		Sku sku = skuService.getSku(id);
		request.setAttribute("sku", sku);
		return "sku/detail";
	}
	
	@RequestMapping("toaddSku")
	public String toaddSku(HttpServletRequest request ,int spuId) {
		Spu spu = spuService.getSpu(spuId);
		request.setAttribute("spu", spu);
		List<Spec> list = specService.listAll();
		System.out.println("list is " + list);
		request.setAttribute("specs", list);
		
		return "sku/add";
	}
	
	@RequestMapping("addSku")
	@ResponseBody
	public String addSku(HttpServletRequest request ,Sku sku,int[] specIds,@RequestParam(value="specOptionIds") int[] specOptionIds) {
		List<SpecOption> specs = new ArrayList<>();
		
		System.out.println("specIds + " + specIds.length + " and specOptionIds is " + specOptionIds.length);
		
		
		for (int i = 0; i < specIds.length && i < specOptionIds.length; i++) {
			int j = specIds[i];
			SpecOption specOption = new SpecOption();
			specOption.setSpecId(specIds[i]);
			specOption.setId(specOptionIds[i]);
			specs.add(specOption);
		}
		sku.setSpecs(specs);
		int addSku = skuService.addSku(sku);
		
		return addSku>0?"success":"failed";
	}
	
	
	
	
}
