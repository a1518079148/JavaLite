package com.ac.support;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

/**
 * 文件工具类
 *
 */
public class FileUtil {

	/**
	 * 
	 *
	 * //项目在Linux执行上线环境的tomcat时获取的项目路径 String realPaths = getRealPath("/");
	 * realPaths = realPaths.substring(0, realPaths.length()-1);
	 * 
	 * //项目在eclipse执行的tomcat时获取的项目路径 String realPaths =
	 * getHttpServletRequest().getRealPath("/");
	 * 
	 * 
	 * 
	 */

	/**
	 * 创建文件
	 * 
	 * @param content - 文件内容
	 * @param filepath - 文件路径
	 * @throws IOException 
	 */
	public static void createNewFile(String content, String filepath) throws IOException {
		Path newFile = Paths.get(filepath);
		if (Files.notExists(newFile)) {
			// 如果文件不存在，则创建文件并写入内容
			BufferedWriter writer = Files.newBufferedWriter(newFile, StandardCharsets.UTF_8);
			writer.write(content);
		}
	}
	
	/**
	 * 对存在的文件追加内容
	 * @param content
	 * @param filepath
	 * @throws IOException 
	 */
	public static void writeContent(String content, String filepath) throws IOException {
		Path newFile = Paths.get(filepath);
		if (!Files.notExists(newFile)) {
			BufferedWriter writer = Files.newBufferedWriter(newFile, StandardCharsets.UTF_8,StandardOpenOption.APPEND);
			writer.write(content);
		}
	}

	/**
     * 创建二维码图片
     * @param file
     * @return
     */
	@SuppressWarnings("static-access")
	public static String createQRCode(String savePath, String qrtext) {
		String substring = savePath.substring(savePath.length()-1, savePath.length());
		if(!substring.equals("\\"))
			savePath += "\\";
		try {
//			qrtext = new String(qrtext.getBytes("utf-8"), "utf-8");
			ByteArrayOutputStream out = QRCode.from(qrtext).to(ImageType.PNG).stream();
			byte[] byteArray = out.toByteArray();
			int random = StringUtils.getRandom(6);
			String filename = savePath + System.currentTimeMillis() + "" + random + ".png";
			new FileUtils().writeByteArrayToFile(new File(filename), byteArray);
			return filename;
		} catch (IOException e) {
			return null;
		}
	}
	
	/**
     * 二维码解码
     * @param file
     * @return
     */
	public static String readQRCode(File file) {
		BufferedImage image;
		try {
			image = ImageIO.read(file);
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new HybridBinarizer(source);
			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
			Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
			hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
			Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码
			return result.getText();
		} catch (Exception e) {
			return null;
		}
	}

	/**
     * 将文件转换成Byte数组
     * @param file
     * @return
     */
	public static byte[] getBytesByFile(File file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
			byte[] b = new byte[1000];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			fis.close();
			byte[] data = bos.toByteArray();
			bos.close();
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 取得文件格式
	 */
	public static String getSuffix(String path) {
		if(path.indexOf(".")<1)
			return null;
		String suffix = path.substring(path.lastIndexOf(".")+1);
		return suffix;
	}
	
	/**
	 * 取得全文件名包括后缀名
	 */
	public static String getFileName(String path) {
		String filename;
		if(path.indexOf(".")<1)
			return null;
		if(path.indexOf("\\")!=-1)
			filename = path.substring(path.lastIndexOf("\\")+1);
		else
			filename = path.substring(path.lastIndexOf("/")+1);
		return filename;
	}
	
	/**
	 * 仅获取文件名
	 */
	public static String getName(String path) {
		String filename;
		if(path.indexOf(".")<1)
			return null;
		if(path.indexOf("\\")!=-1)
			filename = path.substring(path.lastIndexOf("\\")+1);
		else
			filename = path.substring(path.lastIndexOf("/")+1);
		return filename.substring(0, filename.indexOf("."));
	}
	
	public static void main(String[] args) {
		try {
			createNewFile("测试", "C:\\1.txt");
			writeContent("\r测试1", "C:\\1.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
