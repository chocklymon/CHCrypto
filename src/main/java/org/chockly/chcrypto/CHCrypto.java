package org.chockly.chcrypto;

import com.laytonsmith.PureUtilities.SimpleVersion;
import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.core.extensions.AbstractExtension;
import com.laytonsmith.core.extensions.MSExtension;

/**
 * Set up the command helper crypto extension.
 * @author Curtis Oakley
 */
@MSExtension("CHCrypto")
public class CHCrypto extends AbstractExtension {
    
    public Version getVersion() {
        return new SimpleVersion(0,1,0);
    }

    @Override
    public void onStartup() {
        System.out.println("CHCrypto " + getVersion() + " loaded.");
    }
    
    @Override
    public void onShutdown() {
        System.out.println("CHCrypto " + getVersion() + " unloaded.");
    }

}
