package com.ubicoo.shutdown;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.util.Log;

public final class Utils {

	private Utils() {
	}

	public static String readAll(InputStream inputStream) {
		if (inputStream == null) {
			throw new IllegalArgumentException("inputStream cannot be null.");
		}
		try {
			int size = inputStream.available();
			if (size == 0) {
				return "";
			}
			BufferedReader r = new BufferedReader(new InputStreamReader(inputStream), size);
			StringBuilder total = new StringBuilder();
			String line;
			while ((line = r.readLine()) != null) {
				total.append(line);
			}
			return total.toString();
		} catch (IOException e) {
			Log.e(Shutdown.TAG, "Error reading from stream.", e);
			return "";
		}
	}

	/**
	 * Dumps the process output, that is input and error stream.
	 * 
	 * @param process
	 * @return The error output for further analysis, or an empty string.
	 */
	public static String dumpProcessOutput(Process process) {
		if (process == null) {
			throw new IllegalArgumentException("process cannot be null.");
		}
		String stdOut = readAll(process.getInputStream());
		String stdErr = readAll(process.getErrorStream());
		if (stdOut.length() > 0) {
			Log.i(Shutdown.TAG, "Process console output: \n" + stdOut);
		}
		if (stdErr.length() > 0) {
			Log.e(Shutdown.TAG, "Process error output: \n" + stdErr);
		}
		return stdErr;
	}

	public static void killMyProcess() {
		int pid = android.os.Process.myPid();
		android.os.Process.killProcess(pid);
	}
}