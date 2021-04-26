-- 강아지쇼핑몰
DROP SCHEMA IF EXISTS dog_shoppingmall;

-- 강아지쇼핑몰
CREATE SCHEMA dog_shoppingmall;

-- Dog
CREATE TABLE dog_shoppingmall.Dog (
	id        INT          NOT NULL COMMENT '상품 아이디', -- 상품 아이디
	kind      VARCHAR(12)  NOT NULL COMMENT '개 품종', -- 개 품종
	price     INT          NOT NULL COMMENT '개 가격', -- 개 가격
	image     VARCHAR(20)  NOT NULL COMMENT '개 이미지', -- 개 이미지
	country   VARCHAR(12)  NOT NULL COMMENT '원산지', -- 원산지
	height    INT          NULL     COMMENT '평균 개 신장', -- 평균 개 신장
	weight    INT          NULL     COMMENT '평균 개 체중', -- 평균 개 체중
	content   VARCHAR(400) NULL     COMMENT '개 설명', -- 개 설명
	readcount INT          NULL     COMMENT '조회수' -- 조회수
)
COMMENT 'Dog';

-- Dog
ALTER TABLE dog_shoppingmall.Dog
	ADD CONSTRAINT PK_Dog -- Dog 기본키
		PRIMARY KEY (
			id -- 상품 아이디
		);

ALTER TABLE dog_shoppingmall.Dog
	MODIFY COLUMN id INT NOT NULL AUTO_INCREMENT COMMENT '상품 아이디';