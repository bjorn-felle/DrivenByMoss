// Written by Jürgen Moßgraber - mossgrabers.de
// (c) 2017-2022
// Licensed under LGPLv3 - http://www.gnu.org/licenses/lgpl-3.0.txt

package de.mossgrabers.controller.akai.apc;

import de.mossgrabers.framework.configuration.AbstractConfiguration;
import de.mossgrabers.framework.configuration.ISettingsUI;
import de.mossgrabers.framework.controller.valuechanger.IValueChanger;
import de.mossgrabers.framework.daw.IHost;
import de.mossgrabers.framework.daw.midi.ArpeggiatorMode;
import de.mossgrabers.framework.view.Views;

import java.util.List;


/**
 * The configuration settings for APC.
 *
 * @author J&uuml;rgen Mo&szlig;graber
 */
public class APCConfiguration extends AbstractConfiguration
{
    private static final Views [] PREFERRED_NOTE_VIEWS =
    {
        Views.PLAY,
        Views.DRUM,
        Views.SEQUENCER,
        Views.RAINDROPS
    };


    /**
     * Constructor.
     *
     * @param host The DAW host
     * @param valueChanger The value changer
     * @param arpeggiatorModes The available arpeggiator modes
     */
    public APCConfiguration (final IHost host, final IValueChanger valueChanger, final List<ArpeggiatorMode> arpeggiatorModes)
    {
        super (host, valueChanger, arpeggiatorModes);
    }


    /** {@inheritDoc} */
    @Override
    public void init (final ISettingsUI globalSettings, final ISettingsUI documentSettings)
    {
        ///////////////////////////
        // Scale

        this.activateScaleSetting (documentSettings);
        this.activateScaleBaseSetting (documentSettings);
        this.activateScaleInScaleSetting (documentSettings);
        this.activateScaleLayoutSetting (documentSettings);

        ///////////////////////////
        // Play and Sequence

        this.activateQuantizeAmountSetting (globalSettings);
        this.activatePreferredNoteViewSetting (globalSettings, PREFERRED_NOTE_VIEWS);

        ///////////////////////////
        // Workflow

        this.activateExcludeDeactivatedItemsSetting (globalSettings);
        this.activateBehaviourOnStopSetting (globalSettings);
        this.activateSelectClipOnLaunchSetting (globalSettings);
        this.activateNewClipLengthSetting (globalSettings);
    }
}
