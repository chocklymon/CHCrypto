package org.chockly.chcrypto;

import com.laytonsmith.PureUtilities.Common.StringUtils;
import com.laytonsmith.annotations.api;
import com.laytonsmith.core.CHVersion;
import com.laytonsmith.core.Optimizable;
import com.laytonsmith.core.constructs.CString;
import com.laytonsmith.core.constructs.Construct;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.environments.Environment;
import com.laytonsmith.core.exceptions.ConfigCompileException;
import com.laytonsmith.core.exceptions.ConfigRuntimeException;
import com.laytonsmith.core.functions.AbstractFunction;
import com.laytonsmith.core.functions.ExampleScript;
import com.laytonsmith.core.functions.Exceptions.ExceptionType;
import java.security.GeneralSecurityException;
import java.util.EnumSet;
import java.util.Set;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author PseudoKnight
 */
public class Functions {
    
    private static CString getHMAC(String algorithm, Target t, Construct[] args) {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(args[0].val().getBytes(), algorithm);
            Mac mac = Mac.getInstance(algorithm);
            mac.init(signingKey);
            byte[] hmac = mac.doFinal(args[1].val().getBytes());
            String hash = StringUtils.toHex(hmac).toLowerCase();
            return new CString(hash, t);
        } catch (GeneralSecurityException ex) {
            throw new ConfigRuntimeException("An error occured while trying to hash your data", ExceptionType.PluginInternalException, t, ex);
        }
    }
    
    public static String docs() {
        return "Provides access to several cryptographic functions missing from command helper.";
    }
 
    @api
    public static class hmac_md5 extends AbstractFunction implements Optimizable {

        @Override
        public String getName() {
            return "hmac_md5";
        }

        @Override
        public Integer[] numArgs() {
            return new Integer[]{2};
        }

        @Override
        public String docs() {
            return "string {key, val} Returns the md5 HMAC of the specified string using the provided key.";
        }

        @Override
        public ExceptionType[] thrown() {
            return new ExceptionType[]{ExceptionType.PluginInternalException};
        }

        @Override
        public boolean isRestricted() {
            return false;
        }

        @Override
        public CHVersion since() {
            return CHVersion.V3_3_1;
        }

        @Override
        public Boolean runAsync() {
            return null;
        }

        @Override
        public Construct exec(Target t, Environment environment, Construct... args) throws ConfigRuntimeException {
            return getHMAC("HmacMD5", t, args);
        }

        @Override
        public Set<OptimizationOption> optimizationOptions() {
            return EnumSet.of(
                OptimizationOption.CONSTANT_OFFLINE,
                OptimizationOption.CACHE_RETURN
            );
        }

        @Override
        public ExampleScript[] examples() throws ConfigCompileException {
            return new ExampleScript[]{
                new ExampleScript("Basic usage", "hmac_md5('secret_key', 'string')"),
            };
        }
    }

    @api
    public static class hmac_sha1 extends AbstractFunction implements Optimizable {

        @Override
        public String getName() {
            return "hmac_sha1";
        }

        @Override
        public Integer[] numArgs() {
            return new Integer[]{2};
        }

        @Override
        public String docs() {
            return "string {key, val} Returns the sha1 HMAC of the specified string using the provided key.";
        }

        @Override
        public ExceptionType[] thrown() {
            return new ExceptionType[]{ExceptionType.PluginInternalException};
        }

        @Override
        public boolean isRestricted() {
            return false;
        }

        @Override
        public CHVersion since() {
            return CHVersion.V3_3_1;
        }

        @Override
        public Boolean runAsync() {
            return null;
        }

        @Override
        public Construct exec(Target t, Environment environment, Construct... args) throws ConfigRuntimeException {
            return getHMAC("HmacSHA1", t, args);
        }

        @Override
        public Set<OptimizationOption> optimizationOptions() {
            return EnumSet.of(
                OptimizationOption.CONSTANT_OFFLINE,
                OptimizationOption.CACHE_RETURN
            );
        }

        @Override
        public ExampleScript[] examples() throws ConfigCompileException {
            return new ExampleScript[]{
                new ExampleScript("Basic usage", "hmac_sha1('secret_key', 'string')"),
            };
        }
    }

    @api
    public static class hmac_sha256 extends AbstractFunction implements Optimizable {

        @Override
        public String getName() {
            return "hmac_sha256";
        }

        @Override
        public Integer[] numArgs() {
            return new Integer[]{2};
        }

        @Override
        public String docs() {
            return "string {key, val} Returns the sha256 HMAC of the specified string using the provided key.";
        }

        @Override
        public ExceptionType[] thrown() {
            return new ExceptionType[]{ExceptionType.PluginInternalException};
        }

        @Override
        public boolean isRestricted() {
            return false;
        }

        @Override
        public CHVersion since() {
            return CHVersion.V3_3_1;
        }

        @Override
        public Boolean runAsync() {
            return null;
        }

        @Override
        public Construct exec(Target t, Environment environment, Construct... args) throws ConfigRuntimeException {
            return getHMAC("HmacSHA256", t, args);
        }

        @Override
        public Set<OptimizationOption> optimizationOptions() {
            return EnumSet.of(
                OptimizationOption.CONSTANT_OFFLINE,
                OptimizationOption.CACHE_RETURN
            );
        }

        @Override
        public ExampleScript[] examples() throws ConfigCompileException {
            return new ExampleScript[]{
                new ExampleScript("Basic usage", "hmac_sha256('secret_key', 'string')"),
            };
        }
    }
}
