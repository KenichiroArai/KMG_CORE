package kmg.core.infrastructure.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import kmg.core.domain.types.KmgMsgMessageTypes;
import kmg.core.infrastructure.common.KmgMessageTypes;

/**
 * KMGドメイン例外テスト<br>
 *
 * @author KenichiroArai
 *
 * @sine 1.0.0
 *
 * @version 1.0.0
 */
@SuppressWarnings({
    "nls", "static-method"
})
@ExtendWith(MockitoExtension.class)
public class KmgDomainExceptionTest {

    /**
     * constructor メソッドのテスト - 正常系：メッセージタイプのみを指定した場合
     */
    @Test
    public void testConstructor_normalWithMessageTypes() {

        /* 期待値の定義 */
        final KmgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.KMGMSGE11100;
        final String          expectedMessage  = "{0}がありません。";

        /* テスト対象の実行 */
        final KmgDomainException testException = new KmgDomainException(expectedMsgTypes);

        /* 検証の準備 */
        final String          actualMessage  = testException.getMessage();
        final KmgMessageTypes actualMsgTypes = testException.getMessageTypes();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");

    }

    /**
     * constructor メソッドのテスト - 正常系：メッセージタイプとメッセージ引数を指定した場合
     */
    @Test
    public void testConstructor_normalWithMessageTypesAndArgs() {

        /* 期待値の定義 */
        final KmgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.KMGMSGE11100;
        final Object[]        expectedMsgArgs  = {
            "テスト引数1", "テスト引数2"
        };
        final String          expectedMessage  = "テスト引数1がありません。";

        /* テスト対象の実行 */
        final KmgDomainException testException = new KmgDomainException(expectedMsgTypes, expectedMsgArgs);

        /* 検証の準備 */
        final String          actualMessage  = testException.getMessage();
        final KmgMessageTypes actualMsgTypes = testException.getMessageTypes();
        final Object[]        actualMsgArgs  = testException.getMessageArgs();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertArrayEquals(expectedMsgArgs, actualMsgArgs, "メッセージ引数が一致しません");

    }

    /**
     * constructor メソッドのテスト - 正常系：メッセージタイプと原因を指定した場合
     */
    @Test
    public void testConstructor_normalWithMessageTypesAndCause() {

        /* 期待値の定義 */
        final KmgMessageTypes expectedMsgTypes = KmgMsgMessageTypes.KMGMSGE11100;
        final String          expectedMessage  = "{0}がありません。";
        final Throwable       expectedCause    = new RuntimeException("テスト原因");

        /* テスト対象の実行 */
        final KmgDomainException testException = new KmgDomainException(expectedMsgTypes, expectedCause);

        /* 検証の準備 */
        final String          actualMessage  = testException.getMessage();
        final KmgMessageTypes actualMsgTypes = testException.getMessageTypes();
        final Throwable       actualCause    = testException.getCause();

        /* 検証の実施 */
        Assertions.assertEquals(expectedMsgTypes, actualMsgTypes, "メッセージタイプが一致しません");
        Assertions.assertEquals(expectedMessage, actualMessage, "メッセージが一致しません");
        Assertions.assertEquals(expectedCause, actualCause, "原因が一致しません");

    }
}
