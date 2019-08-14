package com.sybercare.hospital.migrate.utils;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;

public class MigrateUtils {
	public static String randomSalt() {
		// 一个Byte占两个字节，此处生成的3字节，字符串长度为6
		SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
		String hex = secureRandom.nextBytes(3).toHex();
		return hex;
	}

	public static String encryptPassword(String username, String password, String salt) {
		return new Md5Hash(username + password + salt).toHex().toString();
	}
}
