package com.ajax.util;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;
import nl.captcha.audio.AudioCaptcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.servlet.CaptchaServletUtil;
import nl.captcha.text.producer.NumbersAnswerProducer;
import nl.captcha.text.producer.TextProducer;
import nl.captcha.text.renderer.DefaultWordRenderer;

public class CaptchaUtil {
	
	private static int width = 150; /* 1. 보안문자 이미지 가로 크기 */ 
	private static int height = 50; /* 2. 보안문자 이미지 세로 크기 */

	/* 3. CaptCha Image 생성 메소드 */ 
	public void getImgCaptCha(HttpServletRequest request, HttpServletResponse response) {
		
		// 4. 폰트 설정 -> font(String name, int style, int size)
		List<Font> fontList = new ArrayList<Font>();
		fontList.add(new Font("", Font.HANGING_BASELINE, 40));  
		fontList.add(new Font("Courier", Font.ITALIC, 40)); 
		fontList.add(new Font("", Font.PLAIN, 40));
		
		// 5. 컬러 설정
		List<Color> colorList = new ArrayList<Color>();
		colorList.add(Color.BLACK);
		
		// 6. 작성할 때 패키지가 2개닌까 하나로 통일해야한다.
		Captcha captcha = new Captcha.Builder(width, height)
					.addText(new NumbersAnswerProducer(6), new DefaultWordRenderer(colorList, fontList))
					.addNoise().addBorder()
					.addBackground(new GradiatedBackgroundProducer())
					.build();
		
		request.getSession().setAttribute(Captcha.NAME, captcha);
		CaptchaServletUtil.writeImage(response, captcha.getImage());
		
	}
	
	/* 7. CaptCha Audio 생성 메소드 */ 
	public void getAudioCaptCha(HttpServletRequest request, HttpServletResponse response, String answer) throws IOException {
		
		HttpSession  session = request.getSession();
		
		Captcha captcha = (Captcha)session.getAttribute(Captcha.NAME);
		
		String getAnswer = answer;
		
		if(getAnswer == null || getAnswer.equals(""))
			getAnswer = captcha.getAnswer();
		
		AudioCaptcha audiocaptcha = new AudioCaptcha.Builder()
				.addAnswer(new SetTextProducer(getAnswer))
				.addNoise()  // 잡음 추가
				.build();
		
		CaptchaServletUtil.writeAudio(response, audiocaptcha.getChallenge());
	}
	
	/* 8. 전달받은 문자열을 그대로 AudioCaptCha가 사용할 수 있도록 TextProducer 인터페이스를 상속받는 클래스 */
	public class SetTextProducer implements TextProducer {
		
		private final String str;
		
		public SetTextProducer(String getAnswer) {
			this.str = getAnswer;
		}

		@Override
		public String getText() {
			// TODO Auto-generated method stub
			return this.str;
		}
		
	}
		
	
}
